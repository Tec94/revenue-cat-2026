package com.restartthread.shared.domain

data class RecoveryThread(
    val id: String,
    val createdAtEpochMs: Long,
    val updatedAtEpochMs: Long = createdAtEpochMs,
    val sourceKind: SourceKind,
    val capturedText: String,
    val proposedAction: String,
    val startedAtEpochMs: Long? = null,
    val status: ThreadStatus = ThreadStatus.ACTIVE,
    val deletedFromStatus: ThreadStatus? = null,
)

enum class SourceKind {
    TEXT,
    VOICE,
}

enum class ThreadStatus {
    ACTIVE,
    COMPLETED,
    ARCHIVED,
    DELETED,
}

data class RecoveryDraft(
    val startHere: String,
    val evidence: String,
    val isGenerated: Boolean,
)
