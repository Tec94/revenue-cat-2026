package com.restartthread.app.platform

import android.app.Application
import android.content.Intent
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.Build
import androidx.core.content.getSystemService
import com.restartthread.app.data.local.EncryptedThreadVault
import com.restartthread.app.widget.RestartThreadWidget
import com.restartthread.shared.domain.RecoveryThread
import com.restartthread.shared.presentation.RestartThreadPlatform
import java.util.UUID

class AndroidRestartThreadPlatform(private val application: Application) : RestartThreadPlatform {
    private val vault = EncryptedThreadVault(application)
    private val recorder = VoiceRecorder(application)
    private val preferences = application.getSharedPreferences(
        "restart_thread_preferences",
        Application.MODE_PRIVATE,
    )

    override fun hasCompletedOnboarding(): Boolean =
        preferences.getBoolean("onboarding_v2_complete", false)

    override fun setOnboardingCompleted(completed: Boolean) {
        preferences.edit().putBoolean("onboarding_v2_complete", completed).apply()
    }

    override fun newThreadId(): String = UUID.randomUUID().toString()

    override fun currentTimeMillis(): Long = System.currentTimeMillis()

    override fun saveThread(thread: RecoveryThread): Boolean =
        runCatching {
            vault.saveThread(thread)
            RestartThreadWidget.refresh(application)
        }.isSuccess

    override fun loadThread(id: String): RecoveryThread? =
        runCatching { vault.loadThread(id) }.getOrNull()

    override fun listThreads(): List<RecoveryThread> = vault.listThreads()

    override fun permanentlyDeleteThread(id: String): Boolean =
        runCatching {
            vault.permanentlyDeleteThread(id).also { if (it) RestartThreadWidget.refresh(application) }
        }.getOrDefault(false)

    override fun exportThread(thread: RecoveryThread): Boolean = runCatching {
        val text = buildString {
            appendLine("Restart Thread")
            appendLine()
            appendLine("You said")
            appendLine(thread.capturedText)
            appendLine()
            appendLine("Start here")
            append(thread.proposedAction)
        }
        val intent = Intent.createChooser(
            Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, text)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            },
            "Export thread",
        ).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        application.startActivity(intent)
    }.isSuccess

    override fun startRecording(): Boolean = runCatching { recorder.start() }.isSuccess

    override fun stopAndSaveVoice(thread: RecoveryThread): Boolean =
        runCatching {
            val capture = recorder.stop()
            val bytes = capture.file.readBytes()
            try {
                vault.saveVoice(thread.id, bytes)
                vault.saveThread(thread)
                RestartThreadWidget.refresh(application)
            } finally {
                bytes.fill(0)
                capture.file.delete()
            }
        }.isSuccess

    override fun cancelRecording() {
        recorder.cancel()
    }

    override fun confirmHaptic() {
        application.getSystemService<Vibrator>()?.let { vibrator ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(
                    VibrationEffect.createOneShot(18L, VibrationEffect.DEFAULT_AMPLITUDE),
                )
            } else {
                @Suppress("DEPRECATION")
                vibrator.vibrate(18L)
            }
        }
    }
}
