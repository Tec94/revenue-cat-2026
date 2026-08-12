package com.restartthread.shared.presentation

import com.restartthread.shared.domain.RecoveryThread

interface RestartThreadPlatform {
    fun newThreadId(): String

    fun currentTimeMillis(): Long

    fun saveThread(thread: RecoveryThread): Boolean

    fun loadThread(id: String): RecoveryThread?

    fun startRecording(): Boolean

    fun stopAndSaveVoice(thread: RecoveryThread): Boolean

    fun cancelRecording()
}
