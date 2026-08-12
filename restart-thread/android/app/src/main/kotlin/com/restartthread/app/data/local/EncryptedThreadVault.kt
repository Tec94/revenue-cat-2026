package com.restartthread.app.data.local

import android.content.Context
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.util.AtomicFile
import com.restartthread.shared.domain.RecoveryThread
import com.restartthread.shared.domain.SourceKind
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.File
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec

class EncryptedThreadVault(context: Context) {
    private val directory = File(context.noBackupFilesDir, VAULT_DIRECTORY).apply { mkdirs() }

    fun saveThread(thread: RecoveryThread) {
        val plain = encodeThread(thread)
        writeEncrypted(File(directory, "${thread.id}.thread"), plain)
    }

    fun saveVoice(threadId: String, audio: ByteArray) {
        require(audio.isNotEmpty())
        writeEncrypted(File(directory, "$threadId.m4a.enc"), audio)
    }

    fun loadThread(id: String): RecoveryThread? {
        val file = File(directory, "$id.thread")
        if (!file.exists()) return null
        return decodeThread(readEncrypted(file))
    }

    private fun writeEncrypted(file: File, plain: ByteArray) {
        val cipher = Cipher.getInstance(TRANSFORMATION)
        cipher.init(Cipher.ENCRYPT_MODE, getOrCreateKey())
        val encrypted = cipher.doFinal(plain)
        val payload = ByteArrayOutputStream().use { bytes ->
            DataOutputStream(bytes).use { output ->
                output.writeInt(FORMAT_VERSION)
                output.writeInt(cipher.iv.size)
                output.write(cipher.iv)
                output.writeInt(encrypted.size)
                output.write(encrypted)
            }
            bytes.toByteArray()
        }

        val atomic = AtomicFile(file)
        val stream = atomic.startWrite()
        try {
            stream.write(payload)
            atomic.finishWrite(stream)
        } catch (error: Throwable) {
            atomic.failWrite(stream)
            throw error
        } finally {
            plain.fill(0)
            encrypted.fill(0)
            payload.fill(0)
        }
    }

    private fun readEncrypted(file: File): ByteArray {
        DataInputStream(ByteArrayInputStream(AtomicFile(file).readFully())).use { input ->
            check(input.readInt() == FORMAT_VERSION) { "Unsupported vault format" }
            val ivSize = input.readInt()
            check(ivSize in 12..16) { "Invalid vault nonce" }
            val iv = ByteArray(ivSize).also(input::readFully)
            val encryptedSize = input.readInt()
            check(encryptedSize > 0 && encryptedSize <= file.length()) { "Invalid vault payload" }
            val encrypted = ByteArray(encryptedSize).also(input::readFully)
            return try {
                Cipher.getInstance(TRANSFORMATION).run {
                    init(Cipher.DECRYPT_MODE, getOrCreateKey(), GCMParameterSpec(128, iv))
                    doFinal(encrypted)
                }
            } finally {
                encrypted.fill(0)
            }
        }
    }

    private fun getOrCreateKey(): SecretKey {
        val keyStore = KeyStore.getInstance(ANDROID_KEYSTORE).apply { load(null) }
        (keyStore.getKey(KEY_ALIAS, null) as? SecretKey)?.let { return it }

        return KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, ANDROID_KEYSTORE).run {
            init(
                KeyGenParameterSpec.Builder(
                    KEY_ALIAS,
                    KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT,
                )
                    .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                    .setKeySize(256)
                    .setRandomizedEncryptionRequired(true)
                    .build(),
            )
            generateKey()
        }
    }

    private fun encodeThread(thread: RecoveryThread): ByteArray =
        ByteArrayOutputStream().use { bytes ->
            DataOutputStream(bytes).use { output ->
                output.writeInt(FORMAT_VERSION)
                output.writeUTF(thread.id)
                output.writeLong(thread.createdAtEpochMs)
                output.writeUTF(thread.sourceKind.name)
                output.writeUTF(thread.capturedText)
                output.writeUTF(thread.proposedAction)
                output.writeBoolean(thread.startedAtEpochMs != null)
                thread.startedAtEpochMs?.let(output::writeLong)
            }
            bytes.toByteArray()
        }

    private fun decodeThread(bytes: ByteArray): RecoveryThread =
        try {
            DataInputStream(ByteArrayInputStream(bytes)).use { input ->
                check(input.readInt() == FORMAT_VERSION)
                RecoveryThread(
                    id = input.readUTF(),
                    createdAtEpochMs = input.readLong(),
                    sourceKind = SourceKind.valueOf(input.readUTF()),
                    capturedText = input.readUTF(),
                    proposedAction = input.readUTF(),
                    startedAtEpochMs = if (input.readBoolean()) input.readLong() else null,
                )
            }
        } finally {
            bytes.fill(0)
        }

    private companion object {
        const val VAULT_DIRECTORY = "restart-thread-vault"
        const val ANDROID_KEYSTORE = "AndroidKeyStore"
        const val KEY_ALIAS = "restart_thread_vault_v1"
        const val TRANSFORMATION = "AES/GCM/NoPadding"
        const val FORMAT_VERSION = 1
    }
}
