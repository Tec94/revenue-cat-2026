import CryptoKit
import Foundation
import RestartThreadCore
import XCTest

final class EncryptedThreadVaultTests: XCTestCase {
    func testRoundTripAndPermanentDeletion() throws {
        let directory = FileManager.default.temporaryDirectory
            .appendingPathComponent(UUID().uuidString, isDirectory: true)
        defer { try? FileManager.default.removeItem(at: directory) }
        let vault = try EncryptedThreadVault(
            directory: directory,
            keyStore: FixedKeyStore()
        )
        let thread = RecoveryThread(
            id: UUID().uuidString,
            createdAtEpochMs: 1,
            sourceKind: .text,
            capturedText: "private source words",
            proposedAction: "one next step"
        )

        try vault.saveThread(thread)

        XCTAssertEqual(try vault.loadThread(id: thread.id), thread)
        let raw = try Data(contentsOf: directory.appendingPathComponent("\(thread.id).thread"))
        XCTAssertFalse(String(data: raw, encoding: .utf8)?.contains(thread.capturedText) == true)
        XCTAssertTrue(vault.permanentlyDeleteThread(id: thread.id))
        XCTAssertNil(try vault.loadThread(id: thread.id))
    }

    func testRejectsPathTraversalIdentifiers() throws {
        let directory = FileManager.default.temporaryDirectory
            .appendingPathComponent(UUID().uuidString, isDirectory: true)
        defer { try? FileManager.default.removeItem(at: directory) }
        let vault = try EncryptedThreadVault(directory: directory, keyStore: FixedKeyStore())

        XCTAssertThrowsError(
            try vault.saveThread(
                RecoveryThread(
                    id: "../outside",
                    createdAtEpochMs: 1,
                    sourceKind: .text,
                    capturedText: "text",
                    proposedAction: "action"
                )
            )
        )
    }

    func testVoiceBytesAreEncryptedAndPermanentlyDeleted() throws {
        let directory = FileManager.default.temporaryDirectory
            .appendingPathComponent(UUID().uuidString, isDirectory: true)
        defer { try? FileManager.default.removeItem(at: directory) }
        let vault = try EncryptedThreadVault(directory: directory, keyStore: FixedKeyStore())
        let threadID = UUID().uuidString
        let audio = Data("private voice bytes".utf8)

        try vault.saveVoice(threadID: threadID, audio: audio)

        let voiceURL = directory.appendingPathComponent("\(threadID).m4a.enc")
        let raw = try Data(contentsOf: voiceURL)
        XCTAssertNotEqual(raw, audio)
        XCTAssertFalse(String(data: raw, encoding: .utf8)?.contains("private voice bytes") == true)
        XCTAssertTrue(vault.permanentlyDeleteThread(id: threadID))
        XCTAssertFalse(FileManager.default.fileExists(atPath: voiceURL.path))
    }
}

private struct FixedKeyStore: SymmetricKeyStoring {
    func loadOrCreateKey() throws -> SymmetricKey {
        SymmetricKey(data: Data(repeating: 7, count: 32))
    }
}
