package com.restartthread.shared

import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.ComposeUIViewController
import com.restartthread.shared.billing.RevenueCatSubscriptionController
import com.restartthread.shared.billing.configureRevenueCat
import com.restartthread.shared.presentation.RestartThreadController
import com.restartthread.shared.presentation.RestartThreadPlatform
import com.restartthread.shared.ui.RestartThreadApp
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIViewController

@OptIn(ExperimentalForeignApi::class)
fun MainViewController(
    platform: RestartThreadPlatform,
    revenueCatApiKey: String,
): UIViewController {
    val revenueCatConfigured = configureRevenueCat(revenueCatApiKey)
    val controller = RestartThreadController(platform)
    val subscriptions = RevenueCatSubscriptionController(revenueCatConfigured)
    return ComposeUIViewController {
        val state by controller.state.collectAsState()
        DisposableEffect(controller) {
            onDispose {
                controller.close()
                subscriptions.close()
            }
        }
        RestartThreadApp(
            state = state,
            subscriptions = subscriptions,
            onInput = controller::setInput,
            onSave = controller::saveText,
            onVoice = {
                if (state.isRecording) {
                    controller.stopAndSaveRecording()
                } else {
                    controller.startRecording()
                }
            },
            onAction = controller::setAction,
            onStart = controller::confirmStart,
            onReset = controller::reset,
        )
    }
}
