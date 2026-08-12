package com.restartthread.app.platform

import android.app.Application
import com.restartthread.app.data.local.EncryptedThreadVault
import com.restartthread.shared.domain.RecoveryThread
import com.restartthread.shared.presentation.RestartThreadPlatform
import java.util.UUID

class AndroidRestartThreadPlatform(application: Application) : RestartThreadPlatform {
    private val vault = EncryptedThreadVault(application)
    private val recorder = VoiceRecorder(application)

    override fun newThreadId(): String = UUID.randomUUID().toString()

    override fun currentTimeMillis(): Long = System.currentTimeMillis()

    override fun saveThread(thread: RecoveryThread): Boolean =
        runCatching { vault.saveThread(thread) }.isSuccess

    override fun loadThread(id: String): RecoveryThread? =
        runCatching { vault.loadThread(id) }.getOrNull()

    override fun startRecording(): Boolean = runCatching { recorder.start() }.isSuccess

    override fun stopAndSaveVoice(thread: RecoveryThread): Boolean =
        runCatching {
            val capture = recorder.stop()
            val bytes = capture.file.readBytes()
            try {
                vault.saveVoice(thread.id, bytes)
                vault.saveThread(thread)
            } finally {
                bytes.fill(0)
                capture.file.delete()
            }
        }.isSuccess

    override fun cancelRecording() {
        recorder.cancel()
    }
}
