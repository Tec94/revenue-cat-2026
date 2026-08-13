package com.restartthread.app.billing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.restartthread.shared.billing.RevenueCatSubscriptionController
import com.restartthread.shared.presentation.MainUiState
import com.restartthread.shared.presentation.AuthUiState
import com.restartthread.shared.presentation.MicrophonePermissionState
import com.restartthread.shared.ui.RestartThreadApp
import com.restartthread.shared.ui.RestartThreadUiActions

@Composable
fun StoreSubscriptionApp(
    state: MainUiState,
    authState: AuthUiState,
    microphonePermission: MicrophonePermissionState,
    actions: RestartThreadUiActions,
) {
    val subscriptions = remember {
        RevenueCatSubscriptionController(enabled = true)
    }
    DisposableEffect(subscriptions) {
        onDispose(subscriptions::close)
    }
    LaunchedEffect(authState.userId) {
        authState.userId?.let(subscriptions::identify) ?: subscriptions.useAnonymousIdentity()
    }

    RestartThreadApp(
        state = state,
        authState = authState,
        microphonePermission = microphonePermission,
        subscriptions = subscriptions,
        actions = actions,
    )
}
