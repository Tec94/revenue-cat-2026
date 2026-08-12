package com.restartthread.shared.domain

object DeterministicRecovery {
    const val SAFE_FIRST_ACTION =
        "Review your saved words, then choose one small, reversible next step."

    fun fromText(text: String): RecoveryDraft {
        require(text.isNotBlank())
        return RecoveryDraft(
            startHere = SAFE_FIRST_ACTION,
            evidence = text.trim(),
            isGenerated = false,
        )
    }

    fun fromSavedVoice(): RecoveryDraft = RecoveryDraft(
        startHere = "Listen to your saved note, then choose one small, reversible next step.",
        evidence = "Voice note saved on this device; no transcript was created.",
        isGenerated = false,
    )
}
