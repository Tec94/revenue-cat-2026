package com.restartthread.app

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.restartthread.app.auth.AndroidAuthGateway
import com.restartthread.app.billing.StoreSubscriptionApp
import com.restartthread.app.widget.RestartThreadWidget
import com.restartthread.shared.presentation.MicrophonePermissionState
import com.restartthread.shared.ui.RestartThreadUiActions

class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var authGateway: AndroidAuthGateway

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authGateway = AndroidAuthGateway(this)
        handleRouteIntent(intent)
        setContent {
            AndroidRestartThreadRoot(
                viewModel = mainViewModel,
                authGateway = authGateway,
                activity = this,
            )
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleRouteIntent(intent)
    }

    override fun onDestroy() {
        authGateway.close()
        super.onDestroy()
    }

    private fun handleRouteIntent(intent: Intent?) {
        val route = intent?.getStringExtra(RestartThreadWidget.EXTRA_ROUTE)
        val threadId = intent?.getStringExtra(RestartThreadWidget.EXTRA_THREAD_ID)
        if (route != null) mainViewModel.controller.handleDeepLink(route, threadId)
    }
}

@Composable
private fun AndroidRestartThreadRoot(
    viewModel: MainViewModel,
    authGateway: AndroidAuthGateway,
    activity: MainActivity,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val authState by authGateway.state.collectAsStateWithLifecycle()
    val controller = viewModel.controller
    var showMicrophoneRationale by remember { mutableStateOf(false) }
    var microphonePermission by remember {
        mutableStateOf(activity.microphonePermissionState())
    }
    LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
        microphonePermission = activity.microphonePermissionState()
    }
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { granted ->
        microphonePermission = if (granted) {
            controller.startRecording()
            MicrophonePermissionState.GRANTED
        } else {
            controller.reportMicrophoneDenied()
            MicrophonePermissionState.NOT_GRANTED
        }
    }

    val actions = RestartThreadUiActions(
        leaveFirstThread = controller::leaveFirstThread,
        tryExample = controller::tryExample,
        showAccountOffer = controller::showAccountOffer,
        completeAccountStep = controller::completeAccountStep,
        signIn = authGateway::login,
        signOut = authGateway::logout,
        deleteCloudAccount = authGateway::deleteCloudAccount,
        goNow = controller::goNow,
        goBack = controller::goBack,
        startNewThread = controller::startNewThread,
        resolveCurrentThread = controller::resolveCurrentThread,
        dismissCurrentSwitch = controller::dismissCurrentSwitch,
        leaveNewStoppingPoint = controller::leaveNewStoppingPoint,
        setInput = controller::setInput,
        saveText = controller::saveText,
        voice = {
            when {
                state.isRecording -> controller.stopAndSaveRecording()
                microphonePermission == MicrophonePermissionState.GRANTED -> controller.startRecording()
                else -> showMicrophoneRationale = true
            }
        },
        setAction = controller::setAction,
        confirmStart = controller::confirmStart,
        finishStarted = controller::finishStarted,
        markCurrentComplete = controller::markCurrentComplete,
        archiveCurrent = controller::archiveCurrent,
        showAllThreads = controller::showAllThreads,
        showRecentlyDeleted = controller::showRecentlyDeleted,
        showSettings = controller::showSettings,
        showDataPrivacy = controller::showDataPrivacy,
        setSearchQuery = controller::setSearchQuery,
        openThread = controller::openThread,
        returnToSelectedThread = controller::returnToSelectedThread,
        editSelectedThread = controller::editSelectedThread,
        completeSelectedThread = controller::completeSelectedThread,
        archiveSelectedThread = controller::archiveSelectedThread,
        deleteSelectedThread = controller::deleteSelectedThread,
        restoreThread = controller::restoreThread,
        permanentlyDeleteThread = controller::permanentlyDeleteThread,
        exportSelectedThread = controller::exportSelectedThread,
        deleteAllLocalThreads = controller::deleteAllLocalThreads,
        requestWidgetPin = { RestartThreadWidget.requestPin(activity) },
        openMicrophoneSettings = {
            activity.startActivity(
                Intent(
                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                    Uri.parse("package:${activity.packageName}"),
                ),
            )
        },
        openPrivacyPolicy = { activity.openWebPage(PRIVACY_URL) },
        openTerms = { activity.openWebPage(TERMS_URL) },
        openSupport = { activity.openWebPage(SUPPORT_URL) },
    )

    StoreSubscriptionApp(
        state = state,
        authState = authState,
        microphonePermission = microphonePermission,
        actions = actions,
    )

    if (showMicrophoneRationale) {
        AlertDialog(
            onDismissRequest = { showMicrophoneRationale = false },
            title = { Text("Record where you left off") },
            text = {
                Text(
                    "Restart Thread needs microphone access only while you record this voice note. " +
                        "The recording is encrypted on this device, and you can always type instead.",
                )
            },
            confirmButton = {
                TextButton(onClick = {
                    showMicrophoneRationale = false
                    permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
                }) {
                    Text("Continue")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    showMicrophoneRationale = false
                    controller.reportMicrophoneDenied()
                }) {
                    Text("Use text")
                }
            },
        )
    }
}

private fun ComponentActivity.microphonePermissionState(): MicrophonePermissionState =
    if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) ==
        PackageManager.PERMISSION_GRANTED
    ) {
        MicrophonePermissionState.GRANTED
    } else {
        MicrophonePermissionState.NOT_GRANTED
    }

private fun ComponentActivity.openWebPage(url: String) {
    runCatching { startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url))) }
}

private const val PRIVACY_URL = "https://restartthread.app/privacy"
private const val TERMS_URL = "https://restartthread.app/terms"
private const val SUPPORT_URL = "https://restartthread.app/support"
