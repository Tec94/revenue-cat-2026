package com.restartthread.shared.presentation

import com.restartthread.shared.domain.RecoveryThread
import com.restartthread.shared.domain.ThreadStatus
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class RestartThreadControllerTest {
    @Test
    fun freshInstallShowsWelcomeAndExampleLeavesNoRecord() {
        val platform = FakePlatform()
        val controller = RestartThreadController(platform)

        assertEquals(AppRoute.WELCOME, controller.state.value.route)
        controller.tryExample()
        assertTrue(controller.state.value.isExample)
        controller.confirmStart()

        assertEquals(AppRoute.ACCOUNT_OFFER, controller.state.value.route)
        assertTrue(platform.threads.isEmpty())
        assertEquals(0, platform.saveCalls)
        assertFalse(platform.onboardingComplete)
    }

    @Test
    fun realStartBecomesTheCurrentThreadOnNow() {
        val platform = FakePlatform()
        val controller = RestartThreadController(platform)

        controller.leaveFirstThread()
        controller.setInput("I stopped while comparing two plans.")
        controller.saveText()
        controller.confirmStart()
        controller.finishStarted()
        controller.completeAccountStep()

        assertEquals(AppRoute.NOW, controller.state.value.route)
        assertNotNull(controller.state.value.currentThread)
        assertEquals(ThreadStatus.ACTIVE, controller.state.value.currentThread?.status)
        assertTrue(platform.onboardingComplete)
    }

    @Test
    fun startingAnotherThreadRequiresAnExplicitCurrentThreadChoice() {
        val platform = FakePlatform(onboardingComplete = true)
        val controller = RestartThreadController(platform)
        controller.startNewThread()
        controller.setInput("First stopping point")
        controller.saveText()
        controller.confirmStart()
        controller.finishStarted()

        controller.startNewThread()
        assertTrue(controller.state.value.showSwitchCurrent)
        assertEquals(1, platform.threads.values.count { it.status == ThreadStatus.ACTIVE })

        controller.resolveCurrentThread(SwitchCurrentChoice.ARCHIVE)
        assertEquals(AppRoute.CAPTURE, controller.state.value.route)
        assertEquals(0, platform.threads.values.count { it.status == ThreadStatus.ACTIVE })
        assertEquals(1, platform.threads.values.count { it.status == ThreadStatus.ARCHIVED })
    }

    @Test
    fun deletedThreadCanBeRestoredWithoutReplacingTheCurrentThread() {
        val platform = FakePlatform(onboardingComplete = true)
        val current = platform.thread("current", ThreadStatus.ACTIVE)
        val archived = platform.thread("archived", ThreadStatus.ARCHIVED)
        val controller = RestartThreadController(platform)

        controller.openThread(archived.id)
        controller.deleteSelectedThread()
        assertEquals(ThreadStatus.DELETED, platform.threads[archived.id]?.status)

        controller.showRecentlyDeleted()
        controller.restoreThread(archived.id)
        assertEquals(ThreadStatus.ARCHIVED, platform.threads[archived.id]?.status)
        assertEquals(ThreadStatus.ACTIVE, platform.threads[current.id]?.status)
    }

    @Test
    fun returnToThreadReopensTheSavedReview() {
        val platform = FakePlatform(onboardingComplete = true)
        val current = platform.thread("current", ThreadStatus.ACTIVE)
        val controller = RestartThreadController(platform)

        controller.openThread(current.id)
        controller.returnToSelectedThread()

        assertEquals(AppRoute.REVIEW, controller.state.value.route)
        assertEquals(current.capturedText, controller.state.value.input)
        assertEquals(current.proposedAction, controller.state.value.action)
    }

    @Test
    fun widgetUpdateUsesTheExactThreadIdAndRejectsAStaleRecord() {
        val platform = FakePlatform(onboardingComplete = true)
        val current = platform.thread("current", ThreadStatus.ACTIVE)
        val archived = platform.thread("archived", ThreadStatus.ARCHIVED)
        val controller = RestartThreadController(platform)

        controller.handleDeepLink("update", current.id)
        assertEquals(AppRoute.CAPTURE, controller.state.value.route)
        assertEquals(current.id, controller.state.value.threadId)

        controller.handleDeepLink("update", archived.id)
        assertEquals(AppRoute.NOW, controller.state.value.route)
        assertEquals("That widget thread is no longer current.", controller.state.value.message)
    }

    @Test
    fun unfinishedCaptureCanBeRestoredAfterProcessDeath() {
        val controller = RestartThreadController(
            platform = FakePlatform(),
            restoredCapture = CaptureSnapshot(
                route = AppRoute.CAPTURE,
                input = "Unsaved words",
                threadId = null,
                evidence = "",
                action = "",
                isAiGenerated = false,
            ),
        )

        assertEquals(AppRoute.CAPTURE, controller.state.value.route)
        assertEquals("Unsaved words", controller.state.value.input)
    }

    @Test
    fun deletingAllLocalDataMovesThreadsToRecoverableDeletion() {
        val platform = FakePlatform(onboardingComplete = true)
        platform.thread("current", ThreadStatus.ACTIVE)
        platform.thread("history", ThreadStatus.COMPLETED)
        val controller = RestartThreadController(platform)

        controller.deleteAllLocalThreads()

        assertTrue(platform.threads.values.all { it.status == ThreadStatus.DELETED })
        assertEquals(AppRoute.NOW, controller.state.value.route)
    }
}

private class FakePlatform(
    var onboardingComplete: Boolean = false,
) : RestartThreadPlatform {
    val threads = linkedMapOf<String, RecoveryThread>()
    var saveCalls = 0
    private var now = 1_000L
    private var nextId = 1

    override fun hasCompletedOnboarding() = onboardingComplete

    override fun setOnboardingCompleted(completed: Boolean) {
        onboardingComplete = completed
    }

    override fun newThreadId() = "thread-${nextId++}"

    override fun currentTimeMillis() = now++

    override fun saveThread(thread: RecoveryThread): Boolean {
        saveCalls++
        threads[thread.id] = thread
        return true
    }

    override fun loadThread(id: String) = threads[id]

    override fun listThreads() = threads.values.sortedByDescending(RecoveryThread::updatedAtEpochMs)

    override fun permanentlyDeleteThread(id: String) = threads.remove(id) != null

    override fun exportThread(thread: RecoveryThread) = true

    override fun startRecording() = true

    override fun stopAndSaveVoice(thread: RecoveryThread): Boolean = saveThread(thread)

    override fun cancelRecording() = Unit

    override fun confirmHaptic() = Unit

    fun thread(id: String, status: ThreadStatus): RecoveryThread = RecoveryThread(
        id = id,
        createdAtEpochMs = now,
        updatedAtEpochMs = now++,
        sourceKind = com.restartthread.shared.domain.SourceKind.TEXT,
        capturedText = "$id captured",
        proposedAction = "$id action",
        status = status,
    ).also { threads[id] = it }
}
