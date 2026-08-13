package com.restartthread.shared.presentation

import com.restartthread.shared.domain.RecoveryThread

interface RestartThreadPlatform {
    fun hasCompletedOnboarding(): Boolean

    fun setOnboardingCompleted(completed: Boolean)

    fun newThreadId(): String

    fun currentTimeMillis(): Long

    fun saveThread(thread: RecoveryThread): Boolean

    fun loadThread(id: String): RecoveryThread?

    fun listThreads(): List<RecoveryThread>

    fun permanentlyDeleteThread(id: String): Boolean

    fun exportThread(thread: RecoveryThread): Boolean

    fun startRecording(): Boolean

    fun stopAndSaveVoice(thread: RecoveryThread): Boolean

    fun cancelRecording()

    fun confirmHaptic()
}
