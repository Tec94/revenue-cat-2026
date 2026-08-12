package com.restartthread.shared.presentation

import com.restartthread.shared.domain.DeterministicRecovery
import com.restartthread.shared.domain.RecoveryThread
import com.restartthread.shared.domain.SourceKind
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class MainUiState(
    val input: String = "",
    val phase: Phase = Phase.CAPTURE,
    val threadId: String? = null,
    val evidence: String = "",
    val action: String = "",
    val message: String? = null,
    val isRecording: Boolean = false,
)

enum class Phase { CAPTURE, REVIEW, STARTED }

class RestartThreadController(
    private val platform: RestartThreadPlatform,
) {
    private val mutableState = MutableStateFlow(MainUiState())
    val state: StateFlow<MainUiState> = mutableState.asStateFlow()

    fun setInput(value: String) {
        mutableState.value = mutableState.value.copy(input = value, message = null)
    }

    fun saveText() {
        val captured = mutableState.value.input.trim()
        if (captured.isBlank()) {
            mutableState.value = mutableState.value.copy(message = "Add a few words first.")
            return
        }

        val id = platform.newThreadId()
        val draft = DeterministicRecovery.fromText(captured)
        val result = platform.saveThread(
            RecoveryThread(
                id = id,
                createdAtEpochMs = platform.currentTimeMillis(),
                sourceKind = SourceKind.TEXT,
                capturedText = captured,
                proposedAction = draft.startHere,
            ),
        )
        mutableState.value = if (result) {
            MainUiState(
                phase = Phase.REVIEW,
                threadId = id,
                evidence = draft.evidence,
                action = draft.startHere,
                message = "Saved on this device.",
            )
        } else {
            mutableState.value.copy(
                message = "Couldn't save. Your words are still here—try again.",
            )
        }
    }

    fun startRecording() {
        val result = platform.startRecording()
        mutableState.value = if (result) {
            mutableState.value.copy(isRecording = true, message = null)
        } else {
            mutableState.value.copy(
                message = "Couldn't start recording. You can type instead.",
            )
        }
    }

    fun stopAndSaveRecording() {
        val id = platform.newThreadId()
        val draft = DeterministicRecovery.fromSavedVoice()
        val result = platform.stopAndSaveVoice(
            RecoveryThread(
                id = id,
                createdAtEpochMs = platform.currentTimeMillis(),
                sourceKind = SourceKind.VOICE,
                capturedText = draft.evidence,
                proposedAction = draft.startHere,
            ),
        )
        mutableState.value = if (result) {
            MainUiState(
                phase = Phase.REVIEW,
                threadId = id,
                evidence = draft.evidence,
                action = draft.startHere,
                message = "Voice note encrypted and saved on this device.",
            )
        } else {
            mutableState.value.copy(
                isRecording = false,
                message = "Couldn't save the recording. Try again or type instead.",
            )
        }
    }

    fun setAction(value: String) {
        mutableState.value = mutableState.value.copy(action = value, message = null)
    }

    fun confirmStart() {
        val current = mutableState.value
        val id = current.threadId ?: return
        if (current.action.isBlank()) {
            mutableState.value = current.copy(message = "Choose a first step before starting.")
            return
        }

        val stored = platform.loadThread(id) ?: run {
            mutableState.value = current.copy(message = "The saved thread couldn't be reopened.")
            return
        }
        val result = platform.saveThread(
            stored.copy(
                proposedAction = current.action.trim(),
                startedAtEpochMs = platform.currentTimeMillis(),
            ),
        )
        mutableState.value = if (result) {
            current.copy(
                phase = Phase.STARTED,
                action = current.action.trim(),
                message = "Restart marked as started.",
            )
        } else {
            current.copy(message = "Couldn't mark this start. Try again.")
        }
    }

    fun reset() {
        platform.cancelRecording()
        mutableState.value = MainUiState()
    }

    fun close() {
        platform.cancelRecording()
    }
}
