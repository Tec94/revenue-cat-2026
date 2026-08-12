package com.restartthread.app.billing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import com.restartthread.shared.billing.RevenueCatSubscriptionController
import com.restartthread.shared.presentation.MainUiState
import com.restartthread.shared.ui.RestartThreadApp

@Composable
fun StoreSubscriptionApp(
    state: MainUiState,
    onInput: (String) -> Unit,
    onSave: () -> Unit,
    onVoice: () -> Unit,
    onAction: (String) -> Unit,
    onStart: () -> Unit,
    onReset: () -> Unit,
) {
    val subscriptions = remember {
        RevenueCatSubscriptionController(enabled = true)
    }
    DisposableEffect(subscriptions) {
        onDispose(subscriptions::close)
    }

    RestartThreadApp(
        state = state,
        subscriptions = subscriptions,
        onInput = onInput,
        onSave = onSave,
        onVoice = onVoice,
        onAction = onAction,
        onStart = onStart,
        onReset = onReset,
    )
}
