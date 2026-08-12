package com.restartthread.shared.domain

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse

class DeterministicRecoveryTest {
    @Test
    fun fallbackPreservesExactSourceAndDoesNotClaimAiGeneration() {
        val source = "Do not email the client yet. Check the figures first."

        val result = DeterministicRecovery.fromText(source)

        assertEquals(source, result.evidence)
        assertEquals(DeterministicRecovery.SAFE_FIRST_ACTION, result.startHere)
        assertFalse(result.isGenerated)
    }

    @Test
    fun blankCaptureCannotCreateARecovery() {
        assertFailsWith<IllegalArgumentException> {
            DeterministicRecovery.fromText("   ")
        }
    }
}
