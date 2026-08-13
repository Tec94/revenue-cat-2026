package com.restartthread.shared.presentation

import com.restartthread.shared.domain.DeterministicRecovery
import com.restartthread.shared.domain.RecoveryThread
import com.restartthread.shared.domain.SourceKind
import com.restartthread.shared.domain.ThreadStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

enum class AppRoute {
    BOOTSTRAP,
    WELCOME,
    EXAMPLE_REVIEW,
    CAPTURE,
    REVIEW,
    STARTED,
    ACCOUNT_OFFER,
    NOW,
    ALL_THREADS,
    THREAD_DETAIL,
    RECENTLY_DELETED,
    SETTINGS,
    DATA_PRIVACY,
}

enum class SwitchCurrentChoice { COMPLETE, ARCHIVE }

enum class CaptureProgress {
    IDLE,
    SAVING,
    SAVED,
    TRANSCRIBING,
    DRAFTING,
    PARTIAL_SUCCESS,
    VOICE_ONLY,
    FAILED,
}

data class MainUiState(
    val route: AppRoute = AppRoute.BOOTSTRAP,
    val onboardingComplete: Boolean = false,
    val input: String = "",
    val threadId: String? = null,
    val evidence: String = "",
    val action: String = "",
    val message: String? = null,
    val isRecording: Boolean = false,
    val isExample: Boolean = false,
    val isAiGenerated: Boolean = false,
    val captureProgress: CaptureProgress = CaptureProgress.IDLE,
    val threads: List<RecoveryThread> = emptyList(),
    val currentThread: RecoveryThread? = null,
    val selectedThread: RecoveryThread? = null,
    val searchQuery: String = "",
    val showSwitchCurrent: Boolean = false,
)

data class CaptureSnapshot(
    val route: AppRoute,
    val input: String,
    val threadId: String?,
    val evidence: String,
    val action: String,
    val isAiGenerated: Boolean,
)

class RestartThreadController(
    private val platform: RestartThreadPlatform,
    restoredCapture: CaptureSnapshot? = null,
) {
    private val mutableState = MutableStateFlow(MainUiState())
    val state: StateFlow<MainUiState> = mutableState.asStateFlow()

    init {
        val completed = platform.hasCompletedOnboarding()
        mutableState.value = if (
            restoredCapture != null && restoredCapture.route in setOf(AppRoute.CAPTURE, AppRoute.REVIEW)
        ) {
            MainUiState(
                route = restoredCapture.route,
                onboardingComplete = completed,
                input = restoredCapture.input,
                threadId = restoredCapture.threadId,
                evidence = restoredCapture.evidence,
                action = restoredCapture.action,
                isAiGenerated = restoredCapture.isAiGenerated,
                message = "Your unfinished thread was restored.",
            )
        } else {
            MainUiState(
                route = if (completed) AppRoute.NOW else AppRoute.WELCOME,
                onboardingComplete = completed,
            )
        }
        if (completed) refreshThreads()
    }

    fun leaveFirstThread() = openCapture()

    fun tryExample() {
        mutableState.value = mutableState.value.copy(
            route = AppRoute.EXAMPLE_REVIEW,
            input = EXAMPLE_CAPTURE,
            action = EXAMPLE_ACTION,
            evidence = EXAMPLE_EVIDENCE,
            threadId = null,
            isExample = true,
            isAiGenerated = false,
            captureProgress = CaptureProgress.IDLE,
            message = null,
        )
    }

    fun showAccountOffer() {
        mutableState.value = mutableState.value.copy(
            route = AppRoute.ACCOUNT_OFFER,
            isExample = false,
            message = null,
        )
    }

    fun completeAccountStep() {
        platform.setOnboardingCompleted(true)
        mutableState.value = mutableState.value.copy(onboardingComplete = true)
        goNow()
    }

    fun goNow() {
        mutableState.value = mutableState.value.copy(
            route = AppRoute.NOW,
            input = "",
            threadId = null,
            evidence = "",
            action = "",
            selectedThread = null,
            isExample = false,
            isAiGenerated = false,
            isRecording = false,
            captureProgress = CaptureProgress.IDLE,
            showSwitchCurrent = false,
            message = null,
        )
        refreshThreads()
    }

    fun goBack() {
        when (mutableState.value.route) {
            AppRoute.DATA_PRIVACY -> {
                mutableState.value = mutableState.value.copy(
                    route = if (mutableState.value.onboardingComplete) AppRoute.SETTINGS else AppRoute.WELCOME,
                    message = null,
                )
            }
            AppRoute.RECENTLY_DELETED -> showAllThreads()
            AppRoute.THREAD_DETAIL -> showAllThreads()
            AppRoute.ALL_THREADS,
            AppRoute.SETTINGS,
            AppRoute.CAPTURE,
            AppRoute.REVIEW,
            AppRoute.STARTED,
            -> goNow()
            AppRoute.BOOTSTRAP,
            AppRoute.WELCOME,
            AppRoute.EXAMPLE_REVIEW,
            AppRoute.ACCOUNT_OFFER,
            AppRoute.NOW,
            -> Unit
        }
    }

    fun startNewThread() {
        refreshThreads()
        if (mutableState.value.currentThread != null) {
            mutableState.value = mutableState.value.copy(showSwitchCurrent = true)
        } else {
            openCapture()
        }
    }

    fun resolveCurrentThread(choice: SwitchCurrentChoice) {
        val current = mutableState.value.currentThread ?: return
        val status = when (choice) {
            SwitchCurrentChoice.COMPLETE -> ThreadStatus.COMPLETED
            SwitchCurrentChoice.ARCHIVE -> ThreadStatus.ARCHIVED
        }
        val updated = current.copy(
            status = status,
            updatedAtEpochMs = platform.currentTimeMillis(),
        )
        if (!platform.saveThread(updated)) {
            mutableState.value = mutableState.value.copy(
                message = "Couldn't update the current thread. Nothing was replaced.",
            )
            return
        }
        mutableState.value = mutableState.value.copy(showSwitchCurrent = false)
        openCapture()
    }

    fun dismissCurrentSwitch() {
        mutableState.value = mutableState.value.copy(showSwitchCurrent = false)
    }

    fun leaveNewStoppingPoint() {
        val current = currentThread() ?: return
        mutableState.value = mutableState.value.copy(
            route = AppRoute.CAPTURE,
            threadId = current.id,
            input = current.capturedText,
            evidence = "",
            action = current.proposedAction,
            message = "Update the point you want to return to.",
            isExample = false,
            isAiGenerated = false,
            captureProgress = CaptureProgress.IDLE,
        )
    }

    fun setInput(value: String) {
        mutableState.value = mutableState.value.copy(
            input = value,
            captureProgress = CaptureProgress.IDLE,
            message = null,
        )
    }

    fun saveText() {
        val currentState = mutableState.value
        val captured = currentState.input.trim()
        if (captured.isBlank()) {
            mutableState.value = currentState.copy(
                captureProgress = CaptureProgress.FAILED,
                message = "Add a few words first.",
            )
            return
        }

        mutableState.value = currentState.copy(captureProgress = CaptureProgress.SAVING)

        val existing = currentState.threadId?.let(platform::loadThread)
        val id = existing?.id ?: platform.newThreadId()
        val now = platform.currentTimeMillis()
        val draft = DeterministicRecovery.fromText(captured)
        val thread = RecoveryThread(
            id = id,
            createdAtEpochMs = existing?.createdAtEpochMs ?: now,
            updatedAtEpochMs = now,
            sourceKind = SourceKind.TEXT,
            capturedText = captured,
            proposedAction = draft.startHere,
            startedAtEpochMs = existing?.startedAtEpochMs,
            status = ThreadStatus.ACTIVE,
        )
        mutableState.value = if (platform.saveThread(thread)) {
            currentState.copy(
                route = AppRoute.REVIEW,
                threadId = id,
                evidence = draft.evidence,
                action = draft.startHere,
                isAiGenerated = draft.isGenerated,
                captureProgress = CaptureProgress.SAVED,
                message = "Saved on this device.",
            )
        } else {
            currentState.copy(
                captureProgress = CaptureProgress.FAILED,
                message = "Couldn't save. Your words are still here—try again.",
            )
        }
    }

    fun startRecording() {
        val result = platform.startRecording()
        mutableState.value = if (result) {
            mutableState.value.copy(
                isRecording = true,
                captureProgress = CaptureProgress.IDLE,
                message = null,
            )
        } else {
            mutableState.value.copy(
                captureProgress = CaptureProgress.FAILED,
                message = "Couldn't start recording. You can type instead.",
            )
        }
    }

    fun reportMicrophoneDenied() {
        mutableState.value = mutableState.value.copy(
            isRecording = false,
            captureProgress = CaptureProgress.FAILED,
            message = "Microphone access wasn't allowed. Text capture is still fully available.",
        )
    }

    fun stopAndSaveRecording() {
        val currentState = mutableState.value
        val existing = currentState.threadId?.let(platform::loadThread)
        val id = existing?.id ?: platform.newThreadId()
        val now = platform.currentTimeMillis()
        val draft = DeterministicRecovery.fromSavedVoice()
        mutableState.value = currentState.copy(captureProgress = CaptureProgress.SAVING)
        val result = platform.stopAndSaveVoice(
            RecoveryThread(
                id = id,
                createdAtEpochMs = existing?.createdAtEpochMs ?: now,
                updatedAtEpochMs = now,
                sourceKind = SourceKind.VOICE,
                capturedText = draft.evidence,
                proposedAction = draft.startHere,
                startedAtEpochMs = existing?.startedAtEpochMs,
                status = ThreadStatus.ACTIVE,
            ),
        )
        mutableState.value = if (result) {
            currentState.copy(
                route = AppRoute.REVIEW,
                threadId = id,
                evidence = draft.evidence,
                action = draft.startHere,
                isRecording = false,
                isAiGenerated = draft.isGenerated,
                captureProgress = CaptureProgress.VOICE_ONLY,
                message = "Voice note encrypted and saved on this device.",
            )
        } else {
            currentState.copy(
                isRecording = false,
                captureProgress = CaptureProgress.FAILED,
                message = "Couldn't save the recording. Try again or type instead.",
            )
        }
    }

    fun setAction(value: String) {
        mutableState.value = mutableState.value.copy(action = value, message = null)
    }

    fun confirmStart() {
        val currentState = mutableState.value
        if (currentState.action.isBlank()) {
            mutableState.value = currentState.copy(message = "Choose a first step before starting.")
            return
        }
        if (currentState.isExample) {
            platform.confirmHaptic()
            mutableState.value = currentState.copy(
                route = AppRoute.ACCOUNT_OFFER,
                input = "",
                action = "",
                evidence = "",
                isExample = false,
                message = null,
            )
            return
        }

        val id = currentState.threadId ?: return
        val stored = platform.loadThread(id) ?: run {
            mutableState.value = currentState.copy(message = "The saved thread couldn't be reopened.")
            return
        }
        val result = platform.saveThread(
            stored.copy(
                proposedAction = currentState.action.trim(),
                startedAtEpochMs = platform.currentTimeMillis(),
                updatedAtEpochMs = platform.currentTimeMillis(),
                status = ThreadStatus.ACTIVE,
                deletedFromStatus = null,
            ),
        )
        mutableState.value = if (result) {
            platform.confirmHaptic()
            currentState.copy(
                route = AppRoute.STARTED,
                action = currentState.action.trim(),
                message = "Restart marked as started.",
            )
        } else {
            currentState.copy(message = "Couldn't mark this start. Try again.")
        }
    }

    fun finishStarted() {
        if (mutableState.value.onboardingComplete) goNow() else showAccountOffer()
    }

    fun markCurrentComplete() = updateCurrentStatus(ThreadStatus.COMPLETED)

    fun archiveCurrent() = updateCurrentStatus(ThreadStatus.ARCHIVED)

    fun showAllThreads() {
        refreshThreads()
        mutableState.value = mutableState.value.copy(route = AppRoute.ALL_THREADS)
    }

    fun showRecentlyDeleted() {
        refreshThreads()
        mutableState.value = mutableState.value.copy(route = AppRoute.RECENTLY_DELETED)
    }

    fun showSettings() {
        mutableState.value = mutableState.value.copy(route = AppRoute.SETTINGS, message = null)
    }

    fun showDataPrivacy() {
        mutableState.value = mutableState.value.copy(route = AppRoute.DATA_PRIVACY, message = null)
    }

    fun setSearchQuery(query: String) {
        mutableState.value = mutableState.value.copy(searchQuery = query)
    }

    fun openThread(id: String) {
        val thread = platform.loadThread(id) ?: return
        mutableState.value = mutableState.value.copy(
            route = AppRoute.THREAD_DETAIL,
            selectedThread = thread,
            message = null,
        )
    }

    fun returnToSelectedThread() {
        val selected = mutableState.value.selectedThread ?: return
        mutableState.value = mutableState.value.copy(
            route = AppRoute.REVIEW,
            threadId = selected.id,
            input = selected.capturedText,
            action = selected.proposedAction,
            evidence = selected.capturedText,
            isExample = false,
            isAiGenerated = false,
            captureProgress = CaptureProgress.SAVED,
            message = null,
        )
    }

    fun editSelectedThread() {
        val selected = mutableState.value.selectedThread ?: return
        mutableState.value = mutableState.value.copy(
            route = AppRoute.CAPTURE,
            threadId = selected.id,
            input = selected.capturedText,
            action = selected.proposedAction,
            evidence = "",
            captureProgress = CaptureProgress.IDLE,
            message = null,
        )
    }

    fun completeSelectedThread() = updateSelectedStatus(ThreadStatus.COMPLETED)

    fun archiveSelectedThread() = updateSelectedStatus(ThreadStatus.ARCHIVED)

    fun deleteSelectedThread() {
        val selected = mutableState.value.selectedThread ?: return
        val deleted = selected.copy(
            status = ThreadStatus.DELETED,
            deletedFromStatus = selected.status,
            updatedAtEpochMs = platform.currentTimeMillis(),
        )
        if (platform.saveThread(deleted)) showAllThreads()
    }

    fun restoreThread(id: String) {
        val thread = platform.loadThread(id) ?: return
        val desiredStatus = thread.deletedFromStatus ?: ThreadStatus.ARCHIVED
        val safeStatus = if (desiredStatus == ThreadStatus.ACTIVE && currentThread() != null) {
            ThreadStatus.ARCHIVED
        } else {
            desiredStatus
        }
        platform.saveThread(
            thread.copy(
                status = safeStatus,
                deletedFromStatus = null,
                updatedAtEpochMs = platform.currentTimeMillis(),
            ),
        )
        refreshThreads()
    }

    fun permanentlyDeleteThread(id: String) {
        platform.permanentlyDeleteThread(id)
        refreshThreads()
    }

    fun exportSelectedThread() {
        val selected = mutableState.value.selectedThread ?: return
        val exported = platform.exportThread(selected)
        mutableState.value = mutableState.value.copy(
            message = if (exported) null else "Couldn't open the export sheet.",
        )
    }

    fun deleteAllLocalThreads() {
        val now = platform.currentTimeMillis()
        platform.listThreads()
            .filter { it.status != ThreadStatus.DELETED }
            .forEach { thread ->
                platform.saveThread(
                    thread.copy(
                        status = ThreadStatus.DELETED,
                        deletedFromStatus = thread.status,
                        updatedAtEpochMs = now,
                    ),
                )
            }
        goNow()
    }

    fun handleDeepLink(route: String?, threadId: String?) {
        when (route) {
            "capture" -> startNewThread()
            "update" -> threadId?.let(::openThreadUpdate) ?: goNow()
            "thread" -> threadId?.let(::openThread) ?: goNow()
            else -> goNow()
        }
    }

    fun close() {
        platform.cancelRecording()
    }

    private fun openCapture() {
        mutableState.value = mutableState.value.copy(
            route = AppRoute.CAPTURE,
            input = "",
            threadId = null,
            evidence = "",
            action = "",
            isExample = false,
            isAiGenerated = false,
            isRecording = false,
            captureProgress = CaptureProgress.IDLE,
            showSwitchCurrent = false,
            message = null,
        )
    }

    private fun openThreadUpdate(id: String) {
        val thread = platform.loadThread(id)
        if (thread == null || thread.status != ThreadStatus.ACTIVE) {
            goNow()
            mutableState.value = mutableState.value.copy(
                message = "That widget thread is no longer current.",
            )
            return
        }
        mutableState.value = mutableState.value.copy(
            route = AppRoute.CAPTURE,
            threadId = thread.id,
            input = thread.capturedText,
            evidence = "",
            action = thread.proposedAction,
            isExample = false,
            isAiGenerated = false,
            isRecording = false,
            captureProgress = CaptureProgress.IDLE,
            showSwitchCurrent = false,
            message = "Update the point you want to return to.",
        )
    }

    private fun updateCurrentStatus(status: ThreadStatus) {
        val current = currentThread() ?: return
        if (platform.saveThread(current.copy(status = status, updatedAtEpochMs = platform.currentTimeMillis()))) {
            if (mutableState.value.onboardingComplete) goNow() else showAccountOffer()
        }
    }

    private fun updateSelectedStatus(status: ThreadStatus) {
        val selected = mutableState.value.selectedThread ?: return
        if (platform.saveThread(selected.copy(status = status, updatedAtEpochMs = platform.currentTimeMillis()))) {
            showAllThreads()
        }
    }

    private fun currentThread(): RecoveryThread? =
        platform.listThreads().firstOrNull { it.status == ThreadStatus.ACTIVE }

    private fun refreshThreads() {
        val threads = platform.listThreads()
        val active = threads.filter { it.status == ThreadStatus.ACTIVE }
        val current = active.firstOrNull()
        active.drop(1).forEach { extra ->
            platform.saveThread(
                extra.copy(
                    status = ThreadStatus.ARCHIVED,
                    updatedAtEpochMs = platform.currentTimeMillis(),
                ),
            )
        }
        val normalized = if (active.size > 1) platform.listThreads() else threads
        mutableState.value = mutableState.value.copy(
            threads = normalized,
            currentThread = current,
            selectedThread = mutableState.value.selectedThread?.id?.let(platform::loadThread),
        )
    }

    private companion object {
        const val EXAMPLE_CAPTURE =
            "I compared the two plans. The annual option looks cheaper after month eight, " +
                "but I still need to check the cancellation fee."
        const val EXAMPLE_ACTION = "Open the pricing sheet and confirm the cancellation fee."
        const val EXAMPLE_EVIDENCE = "I still need to check the cancellation fee."
    }
}
