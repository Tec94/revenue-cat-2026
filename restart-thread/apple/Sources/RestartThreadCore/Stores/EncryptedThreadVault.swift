import CryptoKit
import Foundation
import Security

public protocol SymmetricKeyStoring: Sendable {
    func loadOrCreateKey() throws -> SymmetricKey
}

public enum VaultError: Error, Equatable {
    case invalidIdentifier
    case invalidPayload
    case appGroupUnavailable
    case keychain(OSStatus)
}

public struct KeychainSymmetricKeyStore: SymmetricKeyStoring, Sendable {
    private let service: String
    private let account: String
    private let accessGroup: String?

    public init(
        service: String = "com.restartthread.vault",
        account: String = "restart_thread_vault_v1",
        accessGroup: String? = nil
    ) {
        self.service = service
        self.account = account
        self.accessGroup = accessGroup
    }

    public func loadOrCreateKey() throws -> SymmetricKey {
        if let data = try load() { return SymmetricKey(data: data) }
        var data = Data(count: 32)
        let status = data.withUnsafeMutableBytes { (buffer: UnsafeMutableRawBufferPointer) in
            SecRandomCopyBytes(kSecRandomDefault, buffer.count, buffer.baseAddress!)
        }
        guard status == errSecSuccess else { throw VaultError.keychain(status) }

        if try add(data) {
            return SymmetricKey(data: data)
        }

        // The app and widget can race to create the first key. If another
        // process won, use its key rather than replacing it and orphaning data.
        guard let storedData = try load() else { throw VaultError.invalidPayload }
        return SymmetricKey(data: storedData)
    }

    private func baseQuery() -> [CFString: Any] {
        var query: [CFString: Any] = [
            kSecClass: kSecClassGenericPassword,
            kSecAttrService: service,
            kSecAttrAccount: account,
        ]
        if let accessGroup, !accessGroup.isEmpty {
            query[kSecAttrAccessGroup] = accessGroup
        }
        return query
    }

    private func load() throws -> Data? {
        var query = baseQuery()
        query[kSecReturnData] = true
        query[kSecMatchLimit] = kSecMatchLimitOne
        var result: CFTypeRef?
        let status = SecItemCopyMatching(query as CFDictionary, &result)
        switch status {
        case errSecSuccess:
            guard let data = result as? Data else { throw VaultError.invalidPayload }
            return data
        case errSecItemNotFound:
            return nil
        default:
            throw VaultError.keychain(status)
        }
    }

    private func add(_ data: Data) throws -> Bool {
        var query = baseQuery()
        query[kSecValueData] = data
        query[kSecAttrAccessible] = kSecAttrAccessibleAfterFirstUnlockThisDeviceOnly
        let status = SecItemAdd(query as CFDictionary, nil)
        if status == errSecDuplicateItem { return false }
        if status != errSecSuccess {
            throw VaultError.keychain(status)
        }
        return true
    }
}

public final class EncryptedThreadVault: @unchecked Sendable {
    private let directory: URL
    private let keyStore: SymmetricKeyStoring
    private let encoder = JSONEncoder()
    private let decoder = JSONDecoder()
    private let fileManager: FileManager
    private let lock = NSLock()

    public init(
        directory: URL,
        keyStore: SymmetricKeyStoring,
        fileManager: FileManager = .default
    ) throws {
        self.directory = directory
        self.keyStore = keyStore
        self.fileManager = fileManager
        try fileManager.createDirectory(
            at: directory,
            withIntermediateDirectories: true,
            attributes: nil
        )
        var localDirectory = directory
        var resourceValues = URLResourceValues()
        resourceValues.isExcludedFromBackup = true
        try localDirectory.setResourceValues(resourceValues)
    }

    public convenience init(
        appGroupIdentifier: String,
        keychainAccessGroup: String? = nil,
        fileManager: FileManager = .default
    ) throws {
        guard let base = fileManager.containerURL(
            forSecurityApplicationGroupIdentifier: appGroupIdentifier
        ) else { throw VaultError.appGroupUnavailable }
        try self.init(
            directory: base.appendingPathComponent("restart-thread-vault", isDirectory: true),
            keyStore: KeychainSymmetricKeyStore(accessGroup: keychainAccessGroup),
            fileManager: fileManager
        )
    }

    public func saveThread(_ thread: RecoveryThread) throws {
        try withLock {
            let plain = try encoder.encode(thread)
            try writeEncrypted(plain, to: try threadURL(id: thread.id))
        }
    }

    public func saveVoice(threadID: String, audio: Data) throws {
        guard !audio.isEmpty else { throw VaultError.invalidPayload }
        try withLock {
            try writeEncrypted(audio, to: try voiceURL(id: threadID))
        }
    }

    public func loadThread(id: String) throws -> RecoveryThread? {
        try withLock {
            let url = try threadURL(id: id)
            guard fileManager.fileExists(atPath: url.path) else { return nil }
            return try decoder.decode(RecoveryThread.self, from: readEncrypted(from: url))
        }
    }

    public func listThreads() -> [RecoveryThread] {
        withLock {
            let urls = (try? fileManager.contentsOfDirectory(
                at: directory,
                includingPropertiesForKeys: nil,
                options: [.skipsHiddenFiles]
            )) ?? []
            return urls
                .filter { $0.pathExtension == "thread" }
                .compactMap { url in
                    guard let plain = try? readEncrypted(from: url) else { return nil }
                    return try? decoder.decode(RecoveryThread.self, from: plain)
                }
                .sorted { $0.updatedAtEpochMs > $1.updatedAtEpochMs }
        }
    }

    public func permanentlyDeleteThread(id: String) -> Bool {
        withLock {
            do {
                for url in [try threadURL(id: id), try voiceURL(id: id)] {
                    if fileManager.fileExists(atPath: url.path) {
                        try fileManager.removeItem(at: url)
                    }
                }
                return true
            } catch {
                return false
            }
        }
    }

    private func writeEncrypted(_ plain: Data, to url: URL) throws {
        let key = try keyStore.loadOrCreateKey()
        guard let combined = try AES.GCM.seal(plain, using: key).combined else {
            throw VaultError.invalidPayload
        }
        var payload = Data([1])
        payload.append(combined)
        try payload.write(to: url, options: .atomic)
        #if os(iOS)
        try fileManager.setAttributes(
            [.protectionKey: FileProtectionType.completeUntilFirstUserAuthentication],
            ofItemAtPath: url.path
        )
        #endif
    }

    private func readEncrypted(from url: URL) throws -> Data {
        let payload = try Data(contentsOf: url)
        guard payload.first == 1, payload.count > 1 else { throw VaultError.invalidPayload }
        let box = try AES.GCM.SealedBox(combined: payload.dropFirst())
        return try AES.GCM.open(box, using: keyStore.loadOrCreateKey())
    }

    private func threadURL(id: String) throws -> URL {
        try validatedURL(id: id, suffix: "thread")
    }

    private func voiceURL(id: String) throws -> URL {
        try validatedURL(id: id, suffix: "m4a.enc")
    }

    private func validatedURL(id: String, suffix: String) throws -> URL {
        guard !id.isEmpty,
              !id.contains("/"),
              !id.contains("\\"),
              id != ".",
              id != ".."
        else { throw VaultError.invalidIdentifier }
        return directory.appendingPathComponent("\(id).\(suffix)", isDirectory: false)
    }

    private func withLock<T>(_ body: () throws -> T) rethrows -> T {
        lock.lock()
        defer { lock.unlock() }
        return try body()
    }
}
