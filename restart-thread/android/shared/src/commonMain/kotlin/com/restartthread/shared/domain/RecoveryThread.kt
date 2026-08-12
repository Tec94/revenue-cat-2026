package com.restartthread.shared.domain

data class RecoveryThread(
    val id: String,
    val createdAtEpochMs: Long,
    val sourceKind: SourceKind,
    val capturedText: String,
    val proposedAction: String,
    val startedAtEpochMs: Long? = null,
)

enum class SourceKind {
    TEXT,
    VOICE,
}

data class RecoveryDraft(
    val startHere: String,
    val evidence: String,
    val isGenerated: Boolean,
)
