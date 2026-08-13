package com.restartthread.app.data.local

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.restartthread.shared.domain.RecoveryThread
import com.restartthread.shared.domain.SourceKind
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EncryptedThreadVaultTest {
    @Test
    fun roundTripsThreadThroughAndroidKeystore() {
        val vault = EncryptedThreadVault(ApplicationProvider.getApplicationContext())
        val thread = RecoveryThread(
            id = "instrumentation-thread",
            createdAtEpochMs = 1_000L,
            sourceKind = SourceKind.TEXT,
            capturedText = "Do not send it yet.",
            proposedAction = "Review the saved words.",
        )

        vault.saveThread(thread)

        assertEquals(thread, vault.loadThread(thread.id))
        assertTrue(vault.listThreads().any { it.id == thread.id })
    }
}
