package com.restartthread.app.platform

import android.content.Context
import android.media.MediaRecorder
import android.os.Build
import java.io.File

class VoiceRecorder(private val context: Context) {
    private var recorder: MediaRecorder? = null
    private var output: File? = null
    private var startedAtEpochMs: Long = 0

    fun start() {
        check(recorder == null) { "Recorder already active" }
        val target = File.createTempFile("restart-thread-", ".m4a", context.cacheDir)
        val next = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            MediaRecorder(context)
        } else {
            @Suppress("DEPRECATION")
            MediaRecorder()
        }
        try {
            next.setAudioSource(MediaRecorder.AudioSource.MIC)
            next.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)
            next.setAudioEncoder(MediaRecorder.AudioEncoder.AAC)
            next.setAudioEncodingBitRate(64_000)
            next.setAudioSamplingRate(44_100)
            next.setMaxDuration(MAX_DURATION_MS)
            next.setOutputFile(target.absolutePath)
            next.prepare()
            next.start()
            recorder = next
            output = target
            startedAtEpochMs = System.currentTimeMillis()
        } catch (error: Throwable) {
            next.release()
            target.delete()
            throw error
        }
    }

    fun stop(): RecordedVoice {
        val active = checkNotNull(recorder) { "Recorder is not active" }
        val target = checkNotNull(output)
        val duration = (System.currentTimeMillis() - startedAtEpochMs)
            .coerceAtMost(MAX_DURATION_MS.toLong())
        try {
            active.stop()
            return RecordedVoice(target, duration)
        } catch (error: Throwable) {
            target.delete()
            throw error
        } finally {
            active.release()
            recorder = null
            output = null
            startedAtEpochMs = 0
        }
    }

    fun cancel() {
        runCatching { recorder?.stop() }
        recorder?.release()
        output?.delete()
        recorder = null
        output = null
        startedAtEpochMs = 0
    }

    data class RecordedVoice(val file: File, val durationMs: Long)

    private companion object {
        const val MAX_DURATION_MS = 60_000
    }
}
