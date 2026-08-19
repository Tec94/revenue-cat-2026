import Foundation
import RestartThreadCore
import WidgetKit

#if os(iOS)
import UIKit
#elseif os(macOS)
import AppKit
#endif

@MainActor
public final class AppleRestartThreadPlatform: RestartThreadPlatform {
    public let vault: EncryptedThreadVault
    public let voiceRecorder: AppleVoiceRecorder
    private let defaults: UserDefaults
    private let exporter: ThreadExporter

    public init(configuration: AppConfiguration) throws {
        vault = try EncryptedThreadVault(
            appGroupIdentifier: configuration.appGroupIdentifier,
            keychainAccessGroup: configuration.keychainAccessGroup
        )
        voiceRecorder = AppleVoiceRecorder()
        defaults = UserDefaults(suiteName: configuration.appGroupIdentifier) ?? .standard
        exporter = ThreadExporter()
    }

    public func hasCompletedOnboarding() -> Bool {
        defaults.bool(forKey: "onboarding_v2_complete")
    }

    public func setOnboardingCompleted(_ completed: Bool) {
        defaults.set(completed, forKey: "onboarding_v2_complete")
    }

    public func newThreadID() -> String { UUID().uuidString }

    public func currentTimeMillis() -> Int64 {
        Int64(Date().timeIntervalSince1970 * 1_000)
    }

    public func saveThread(_ thread: RecoveryThread) -> Bool {
        do {
            try vault.saveThread(thread)
            WidgetCenter.shared.reloadAllTimelines()
            return true
        } catch {
            return false
        }
    }

    public func loadThread(id: String) -> RecoveryThread? {
        try? vault.loadThread(id: id)
    }

    public func listThreads() -> [RecoveryThread] { vault.listThreads() }

    public func permanentlyDeleteThread(id: String) -> Bool {
        let deleted = vault.permanentlyDeleteThread(id: id)
        if deleted { WidgetCenter.shared.reloadAllTimelines() }
        return deleted
    }

    public func exportThread(_ thread: RecoveryThread) -> Bool { exporter.export(thread) }

    public func startRecording() -> Bool {
        do {
            try voiceRecorder.start()
            return true
        } catch {
            return false
        }
    }

    public func stopAndSaveVoice(thread: RecoveryThread) -> Bool {
        do {
            let audio = try voiceRecorder.stop()
            try vault.saveVoice(threadID: thread.id, audio: audio)
            try vault.saveThread(thread)
            WidgetCenter.shared.reloadAllTimelines()
            return true
        } catch {
            voiceRecorder.cancel()
            return false
        }
    }

    public func cancelRecording() { voiceRecorder.cancel() }

    public func confirmHaptic() {
        #if os(iOS)
        UINotificationFeedbackGenerator().notificationOccurred(.success)
        #else
        NSHapticFeedbackManager.defaultPerformer.perform(.alignment, performanceTime: .now)
        #endif
    }
}
