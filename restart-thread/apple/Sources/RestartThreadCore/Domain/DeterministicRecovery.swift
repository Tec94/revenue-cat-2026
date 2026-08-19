import Foundation

public enum DeterministicRecovery {
    public static let safeFirstAction =
        "Review your saved words, then choose one small, reversible next step."

    public static func fromText(_ text: String) -> RecoveryDraft? {
        let captured = text.trimmingCharacters(in: .whitespacesAndNewlines)
        guard !captured.isEmpty else { return nil }
        return RecoveryDraft(
            startHere: safeFirstAction,
            evidence: captured,
            isGenerated: false
        )
    }

    public static func fromSavedVoice() -> RecoveryDraft {
        RecoveryDraft(
            startHere: "Listen to your saved note, then choose one small, reversible next step.",
            evidence: "Voice note saved on this device; no transcript was created.",
            isGenerated: false
        )
    }
}
