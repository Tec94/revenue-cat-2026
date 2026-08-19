import Foundation

@MainActor
public protocol RestartThreadPlatform: AnyObject {
    func hasCompletedOnboarding() -> Bool
    func setOnboardingCompleted(_ completed: Bool)
    func newThreadID() -> String
    func currentTimeMillis() -> Int64
    func saveThread(_ thread: RecoveryThread) -> Bool
    func loadThread(id: String) -> RecoveryThread?
    func listThreads() -> [RecoveryThread]
    func permanentlyDeleteThread(id: String) -> Bool
    func exportThread(_ thread: RecoveryThread) -> Bool
    func startRecording() -> Bool
    func stopAndSaveVoice(thread: RecoveryThread) -> Bool
    func cancelRecording()
    func confirmHaptic()
}

public protocol CaptureSnapshotPersisting: AnyObject {
    func loadSnapshot() -> CaptureSnapshot?
    func saveSnapshot(_ snapshot: CaptureSnapshot?)
}

public final class UserDefaultsCaptureSnapshotStore: CaptureSnapshotPersisting {
    private let defaults: UserDefaults
    private let key: String
    private let encoder = JSONEncoder()
    private let decoder = JSONDecoder()

    public init(defaults: UserDefaults = .standard, key: String = "capture_snapshot_v1") {
        self.defaults = defaults
        self.key = key
    }

    public func loadSnapshot() -> CaptureSnapshot? {
        defaults.data(forKey: key).flatMap { try? decoder.decode(CaptureSnapshot.self, from: $0) }
    }

    public func saveSnapshot(_ snapshot: CaptureSnapshot?) {
        guard let snapshot, let data = try? encoder.encode(snapshot) else {
            defaults.removeObject(forKey: key)
            return
        }
        defaults.set(data, forKey: key)
    }
}
