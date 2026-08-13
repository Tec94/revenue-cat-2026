package com.restartthread.shared.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.restartthread.shared.billing.SubscriptionUiState
import com.restartthread.shared.domain.RecoveryThread
import com.restartthread.shared.domain.ThreadStatus
import com.restartthread.shared.presentation.AppRoute
import com.restartthread.shared.presentation.AuthUiState
import com.restartthread.shared.presentation.CaptureProgress
import com.restartthread.shared.presentation.MainUiState
import com.restartthread.shared.presentation.MicrophonePermissionState
import com.restartthread.shared.presentation.SwitchCurrentChoice

private val Paper = Color(0xFFFAFAF7)
private val Ink = Color(0xFF111111)
private val Gray = Color(0xFF545454)
private val ActionRed = Color(0xFFA91D3A)
private val ActionEdge = Color(0xFF6F0E26)
private val PaleRed = Color(0xFFF8E7EB)
private val Rule = Color(0xFFD8D5CF)

private val RestartTypography = Typography(
    displayLarge = Typography().displayLarge.copy(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        lineHeight = 44.sp,
    ),
    headlineLarge = Typography().headlineLarge.copy(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        lineHeight = 36.sp,
    ),
    headlineMedium = Typography().headlineMedium.copy(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Bold,
    ),
)

@Composable
fun RestartThreadScreen(
    state: MainUiState,
    authState: AuthUiState = AuthUiState(),
    microphonePermission: MicrophonePermissionState = MicrophonePermissionState.NOT_GRANTED,
    subscriptionState: SubscriptionUiState = SubscriptionUiState(),
    onUpgrade: (() -> Unit)? = null,
    onManageSubscription: (() -> Unit)? = null,
    actions: RestartThreadUiActions,
) {
    MaterialTheme(typography = RestartTypography) {
        Surface(color = Paper, contentColor = Ink, modifier = Modifier.fillMaxSize()) {
            BoxWithConstraints(Modifier.fillMaxSize()) {
                val horizontalPadding = if (maxWidth >= 600.dp) 48.dp else 20.dp
                Column(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .fillMaxSize()
                        .widthIn(max = 760.dp)
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = horizontalPadding, vertical = 24.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                ) {
                    if (state.route !in setOf(AppRoute.BOOTSTRAP, AppRoute.WELCOME)) {
                        BrandHeader(
                            showBack = state.onboardingComplete &&
                                state.route !in setOf(AppRoute.NOW, AppRoute.ACCOUNT_OFFER),
                            onBack = actions.goNow,
                            onSettings = actions.showSettings,
                        )
                    }
                    RouteContent(
                        state = state,
                        authState = authState,
                        microphonePermission = microphonePermission,
                        subscriptionState = subscriptionState,
                        onUpgrade = onUpgrade,
                        onManageSubscription = onManageSubscription,
                        actions = actions,
                    )
                    state.message?.let {
                        Text(it, color = Gray, style = MaterialTheme.typography.bodyMedium)
                    }
                }

                if (state.showSwitchCurrent) {
                    SwitchCurrentDialog(state.currentThread, actions)
                }
            }
        }
    }
}

@Composable
private fun RouteContent(
    state: MainUiState,
    authState: AuthUiState,
    microphonePermission: MicrophonePermissionState,
    subscriptionState: SubscriptionUiState,
    onUpgrade: (() -> Unit)?,
    onManageSubscription: (() -> Unit)?,
    actions: RestartThreadUiActions,
) {
    when (state.route) {
        AppRoute.BOOTSTRAP -> BootstrapScreen()
        AppRoute.WELCOME -> WelcomeScreen(actions)
        AppRoute.EXAMPLE_REVIEW -> ReviewScreen(state, actions, isExample = true)
        AppRoute.CAPTURE -> CaptureScreen(state, actions)
        AppRoute.REVIEW -> ReviewScreen(state, actions, isExample = false)
        AppRoute.STARTED -> StartedScreen(state, actions)
        AppRoute.ACCOUNT_OFFER -> AccountOfferScreen(authState, actions)
        AppRoute.NOW -> NowScreen(state, actions)
        AppRoute.ALL_THREADS -> AllThreadsScreen(state, actions)
        AppRoute.THREAD_DETAIL -> ThreadDetailScreen(state, actions)
        AppRoute.RECENTLY_DELETED -> RecentlyDeletedScreen(state, actions)
        AppRoute.SETTINGS -> SettingsScreen(
            authState = authState,
            microphonePermission = microphonePermission,
            subscriptionState = subscriptionState,
            onUpgrade = onUpgrade,
            onManageSubscription = onManageSubscription,
            actions = actions,
        )
        AppRoute.DATA_PRIVACY -> DataPrivacyScreen(actions)
    }
}

@Composable
private fun BootstrapScreen() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 96.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(18.dp),
    ) {
        BrandMark(MarkKind.OPEN, Modifier.size(112.dp))
        Text("Restart Thread", style = MaterialTheme.typography.headlineLarge)
    }
}

@Composable
private fun WelcomeScreen(actions: RestartThreadUiActions) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 28.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        BrandMark(MarkKind.OPEN, Modifier.size(128.dp))
        Text(
            "Say where you are.\nStart again from one clear step.",
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.semantics { heading() },
        )
        Text(
            "Leave a thread in your own words. Restart Thread keeps it on this device " +
                "and helps you choose one place to begin.",
            color = Gray,
            style = MaterialTheme.typography.bodyLarge,
        )
        TactilePrimaryButton("Leave my first thread", actions.leaveFirstThread)
        OutlinedAction("Try the 20-second example", actions.tryExample)
        TextButton(onClick = actions.showAccountOffer, modifier = Modifier.fillMaxWidth()) {
            Text("Sign in")
        }
        TextButton(onClick = actions.showDataPrivacy, modifier = Modifier.fillMaxWidth()) {
            Text("How your data stays local")
        }
    }
}

@Composable
private fun CaptureScreen(state: MainUiState, actions: RestartThreadUiActions) {
    ScreenTitle("Where were you?")
    Text(
        "Say or type what is true right now. It saves on this device before anything else happens.",
        color = Gray,
    )
    OutlinedTextField(
        value = state.input,
        onValueChange = actions.setInput,
        modifier = Modifier.fillMaxWidth(),
        minLines = 5,
        label = { Text("Current state") },
        placeholder = { Text("I was working on… The part blocking me is…") },
    )
    CaptureProgressLabel(state.captureProgress)
    TactilePrimaryButton("Save and find a first step", actions.saveText, container = Ink)
    OutlinedAction(
        if (state.isRecording) "Stop and save voice note" else "Record a voice note",
        actions.voice,
    )
    Text(
        "Voice and text are equal routes. Microphone access is requested only when you choose voice.",
        color = Gray,
        style = MaterialTheme.typography.bodySmall,
    )
}

@Composable
private fun ReviewScreen(
    state: MainUiState,
    actions: RestartThreadUiActions,
    isExample: Boolean,
) {
    ReviewContent(state, actions, isExample)
}

@Composable
private fun ReviewContent(
    state: MainUiState,
    actions: RestartThreadUiActions,
    isExample: Boolean,
) {
    val whyVisible = remember(state.route, state.threadId) { androidx.compose.runtime.mutableStateOf(false) }
    if (isExample) {
        Text("20-second example", color = ActionRed, fontWeight = FontWeight.Bold)
        Text("Nothing here is saved or sent.", color = Gray)
    }
    ScreenTitle("Start here")
    CaptureProgressLabel(state.captureProgress)
    EvidenceCard(label = "YOU SAID", text = state.input.ifBlank { state.evidence })
    DottedTrace()
    OutlinedTextField(
        value = state.action,
        onValueChange = actions.setAction,
        modifier = Modifier.fillMaxWidth(),
        minLines = 3,
        label = { Text("Editable first step") },
        supportingText = {
            Text(
                if (state.isAiGenerated) "AI draft. You stay in control. Nothing starts automatically."
                else "You stay in control. Nothing starts automatically.",
            )
        },
    )
    TactilePrimaryButton("Start this step", actions.confirmStart)
    OutlinedButton(
        onClick = { whyVisible.value = !whyVisible.value },
        modifier = Modifier.height(48.dp).alignStart(),
        shape = RoundedCornerShape(8.dp),
    ) {
        Text(if (whyVisible.value) "Hide source" else "Why this?")
    }
    if (whyVisible.value) {
        DottedTrace()
        SourceEvidence(state.evidence)
    }
    if (!isExample) {
        TextButton(onClick = actions.goNow, modifier = Modifier.fillMaxWidth()) {
            Text("Save and return later")
        }
    }
}

@Composable
private fun CaptureProgressLabel(progress: CaptureProgress) {
    val label = when (progress) {
        CaptureProgress.IDLE -> return
        CaptureProgress.SAVING -> "Saving locally…"
        CaptureProgress.SAVED -> "Saved locally"
        CaptureProgress.TRANSCRIBING -> "Transcribing voice note…"
        CaptureProgress.DRAFTING -> "Drafting a first step…"
        CaptureProgress.PARTIAL_SUCCESS -> "Saved locally; part of the draft needs attention"
        CaptureProgress.VOICE_ONLY -> "Voice note saved locally; transcription is not available yet"
        CaptureProgress.FAILED -> "Not saved yet"
    }
    Text(label, color = Gray, style = MaterialTheme.typography.bodySmall)
}

@Composable
private fun StartedScreen(state: MainUiState, actions: RestartThreadUiActions) {
    Spacer(Modifier.height(24.dp))
    ScreenTitle("You moved it forward.")
    Text(state.action, style = MaterialTheme.typography.titleLarge)
    Text("This is a verified restart—not just an app open.", color = Gray)
    TactilePrimaryButton("Back to Now", actions.finishStarted, container = Ink)
    OutlinedAction("Leave a new stopping point", actions.leaveNewStoppingPoint)
    TextButton(onClick = actions.markCurrentComplete, modifier = Modifier.fillMaxWidth()) {
        Text("Mark complete")
    }
    TextButton(onClick = actions.archiveCurrent, modifier = Modifier.fillMaxWidth()) {
        Text("Archive")
    }
}

@Composable
private fun AccountOfferScreen(authState: AuthUiState, actions: RestartThreadUiActions) {
    Spacer(Modifier.height(20.dp))
    ScreenTitle("Keep Pro and cloud access with you.")
    Text(
        "An account links your Pro entitlement, cloud allowance, web purchases, and future " +
            "referrals. Your thread text and audio remain on this device.",
        color = Gray,
    )
    if (authState.isAuthenticated) {
        EvidenceCard("SIGNED IN", authState.displayName ?: "Your account is connected.")
        TactilePrimaryButton("Continue to Now", actions.completeAccountStep)
    } else {
        TactilePrimaryButton(
            if (authState.isLoading) "Opening secure sign-in…" else "Create or sign in",
            actions.signIn,
        )
        OutlinedAction("Continue without an account", actions.completeAccountStep)
    }
    if (!authState.isConfigured) {
        Text(
            "Sign-in needs the Auth0 public configuration before it can open. Local use is available now.",
            color = Gray,
            style = MaterialTheme.typography.bodySmall,
        )
    }
    authState.message?.let { Text(it, color = Gray) }
}

@Composable
private fun NowScreen(state: MainUiState, actions: RestartThreadUiActions) {
    ScreenTitle("Now")
    val current = state.currentThread
    if (current == null) {
        Column(
            modifier = Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(12.dp)).padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text("Nothing is waiting here", style = MaterialTheme.typography.titleLarge)
            Text("Leave where you are so one clear step is ready when you return.", color = Gray)
            TactilePrimaryButton("Leave a thread", actions.startNewThread)
        }
    } else {
        ReturnCard(current, actions)
        OutlinedAction("Update stopping point", actions.leaveNewStoppingPoint)
    }

    val recents = state.threads
        .filter { it.status != ThreadStatus.DELETED && it.id != current?.id }
        .take(3)
    if (recents.isNotEmpty()) {
        SectionLabel("RECENT")
        recents.forEach { ThreadRow(it, actions.openThread) }
    }
    OutlinedAction("All threads", actions.showAllThreads)
    TextButton(onClick = actions.showSettings, modifier = Modifier.fillMaxWidth()) {
        Text("Settings")
    }
}

@Composable
private fun ReturnCard(thread: RecoveryThread, actions: RestartThreadUiActions) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Ink, RoundedCornerShape(14.dp))
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text("RETURN TO THREAD", color = Color(0xFFFF8298), fontWeight = FontWeight.Bold)
        Text(thread.capturedText, color = Paper, style = MaterialTheme.typography.bodyLarge)
        HorizontalDivider(color = Color.White.copy(alpha = 0.25f))
        Text(thread.proposedAction, color = Paper, style = MaterialTheme.typography.titleLarge)
        Button(
            onClick = { actions.openThread(thread.id) },
            colors = ButtonDefaults.buttonColors(containerColor = ActionRed, contentColor = Color.White),
            modifier = Modifier.fillMaxWidth().height(48.dp),
        ) {
            Text("Return to thread")
        }
    }
}

@Composable
private fun AllThreadsScreen(state: MainUiState, actions: RestartThreadUiActions) {
    ScreenTitle("All threads")
    OutlinedTextField(
        value = state.searchQuery,
        onValueChange = actions.setSearchQuery,
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Search saved words and first steps") },
        singleLine = true,
    )
    val query = state.searchQuery.trim()
    val visible = state.threads.filter { thread ->
        thread.status != ThreadStatus.DELETED && (
            query.isBlank() || thread.capturedText.contains(query, ignoreCase = true) ||
                thread.proposedAction.contains(query, ignoreCase = true)
            )
    }
    if (visible.isEmpty()) {
        Text("No threads match this search.", color = Gray)
    } else {
        ThreadStatus.entries.filter { it != ThreadStatus.DELETED }.forEach { status ->
            val section = visible.filter { it.status == status }
            if (section.isNotEmpty()) {
                SectionLabel(status.name)
                section.forEach { ThreadRow(it, actions.openThread) }
            }
        }
    }
    TextButton(onClick = actions.showRecentlyDeleted, modifier = Modifier.fillMaxWidth()) {
        Text("Recently Deleted")
    }
}

@Composable
private fun ThreadDetailScreen(state: MainUiState, actions: RestartThreadUiActions) {
    val thread = state.selectedThread ?: run {
        Text("This thread is unavailable.", color = Gray)
        return
    }
    Text(thread.status.name.lowercase().replaceFirstChar { it.uppercase() }, color = ActionRed)
    ScreenTitle("Thread detail")
    EvidenceCard("YOU SAID", thread.capturedText)
    SectionLabel("START HERE")
    Text(thread.proposedAction, style = MaterialTheme.typography.titleLarge)
    OutlinedAction("Edit", actions.editSelectedThread)
    if (thread.status == ThreadStatus.ACTIVE) {
        TactilePrimaryButton("Return to thread", actions.returnToSelectedThread)
        OutlinedAction("Update stopping point", actions.editSelectedThread)
        TextButton(onClick = actions.completeSelectedThread, modifier = Modifier.fillMaxWidth()) {
            Text("Mark complete")
        }
    }
    TextButton(onClick = actions.archiveSelectedThread, modifier = Modifier.fillMaxWidth()) {
        Text("Archive")
    }
    TextButton(onClick = actions.exportSelectedThread, modifier = Modifier.fillMaxWidth()) {
        Text("Export")
    }
    TextButton(onClick = actions.deleteSelectedThread, modifier = Modifier.fillMaxWidth()) {
        Text("Delete", color = ActionRed)
    }
}

@Composable
private fun RecentlyDeletedScreen(state: MainUiState, actions: RestartThreadUiActions) {
    ScreenTitle("Recently Deleted")
    Text(
        "Restore a thread or delete it permanently. Restart Thread does not silently expire these records.",
        color = Gray,
    )
    val deleted = state.threads.filter { it.status == ThreadStatus.DELETED }
    if (deleted.isEmpty()) {
        Text("Nothing has been deleted.", color = Gray)
    }
    deleted.forEach { thread ->
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(thread.proposedAction, style = MaterialTheme.typography.titleMedium)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedButton(onClick = { actions.restoreThread(thread.id) }) { Text("Restore") }
                TextButton(onClick = { actions.permanentlyDeleteThread(thread.id) }) {
                    Text("Delete permanently", color = ActionRed)
                }
            }
            HorizontalDivider(color = Rule)
        }
    }
}

@Composable
private fun SettingsScreen(
    authState: AuthUiState,
    microphonePermission: MicrophonePermissionState,
    subscriptionState: SubscriptionUiState,
    onUpgrade: (() -> Unit)?,
    onManageSubscription: (() -> Unit)?,
    actions: RestartThreadUiActions,
) {
    val confirmLocalDelete = remember { mutableStateOf(false) }
    val confirmCloudDelete = remember { mutableStateOf(false) }
    ScreenTitle("Settings")
    SettingsSection("ACCOUNT") {
        Text(
            when {
                authState.isAuthenticated -> authState.displayName ?: "Signed in"
                authState.isConfigured -> "Using Restart Thread without an account"
                else -> "Local-only use; Auth0 is not configured"
            },
        )
        if (authState.isAuthenticated) {
            TextButton(onClick = actions.signOut) { Text("Sign out") }
            TextButton(onClick = { confirmCloudDelete.value = true }) {
                Text("Delete cloud account", color = ActionRed)
            }
        } else {
            TextButton(onClick = actions.signIn) { Text("Create or sign in") }
        }
    }
    SettingsSection("RESTART THREAD PRO") {
        Text(if (subscriptionState.isPro) "Pro is active" else "Free plan")
        if (subscriptionState.isPro && onManageSubscription != null) {
            OutlinedAction("Open Customer Center", onManageSubscription)
        } else if (onUpgrade != null) {
            OutlinedAction("Explore Pro", onUpgrade)
        }
        TextButton(onClick = actions.restorePurchases) { Text("Restore Purchases") }
        subscriptionState.statusMessage?.let { Text(it, color = Gray) }
    }
    SettingsSection("VOICE AND AI") {
        Text("Thread text and audio stay encrypted on this device.", color = Gray)
        Text(
            if (microphonePermission == MicrophonePermissionState.GRANTED) {
                "Microphone access is allowed"
            } else {
                "Microphone access is not allowed"
            },
        )
        TextButton(onClick = actions.openMicrophoneSettings) { Text("Open microphone settings") }
    }
    SettingsSection("DATA") {
        TextButton(onClick = actions.showDataPrivacy) { Text("Privacy and local data") }
        Text("Export is available from each thread.", color = Gray)
        TextButton(onClick = { confirmLocalDelete.value = true }) {
            Text("Delete all local threads", color = ActionRed)
        }
    }
    SettingsSection("ANDROID") {
        OutlinedAction("Add home widget", actions.requestWidgetPin)
        Text(
            "The widget can show the current first step. Add it only where that is private enough.",
            color = Gray,
        )
    }
    SettingsSection("ABOUT") {
        TextButton(onClick = actions.openPrivacyPolicy) { Text("Privacy policy") }
        TextButton(onClick = actions.openTerms) { Text("Terms") }
        TextButton(onClick = actions.openSupport) { Text("Support") }
    }
    if (confirmLocalDelete.value) {
        AlertDialog(
            onDismissRequest = { confirmLocalDelete.value = false },
            title = { Text("Delete all local threads?") },
            text = { Text("They move to Recently Deleted and can still be restored or removed permanently.") },
            confirmButton = {
                TextButton(onClick = {
                    confirmLocalDelete.value = false
                    actions.deleteAllLocalThreads()
                }) { Text("Move to Recently Deleted", color = ActionRed) }
            },
            dismissButton = {
                TextButton(onClick = { confirmLocalDelete.value = false }) { Text("Cancel") }
            },
        )
    }
    if (confirmCloudDelete.value) {
        AlertDialog(
            onDismissRequest = { confirmCloudDelete.value = false },
            title = { Text("Delete the cloud account?") },
            text = {
                Text("This removes the Auth0 account and account-bound allowance data. Local threads stay on this device.")
            },
            confirmButton = {
                TextButton(onClick = {
                    confirmCloudDelete.value = false
                    actions.deleteCloudAccount()
                }) { Text("Delete cloud account", color = ActionRed) }
            },
            dismissButton = {
                TextButton(onClick = { confirmCloudDelete.value = false }) { Text("Cancel") }
            },
        )
    }
}

@Composable
private fun DataPrivacyScreen(actions: RestartThreadUiActions) {
    ScreenTitle("Your thread stays with you.")
    Text(
        "Restart Thread saves thread text and voice in an encrypted vault on this device before " +
            "any optional processing. The guided example is disposable and never enters the vault.",
    )
    EvidenceCard(
        "ACCOUNTS",
        "Signing in links Pro and cloud allowance. It does not turn on thread sync and the backend " +
            "does not receive your thread text or audio.",
    )
    EvidenceCard(
        "YOUR CHOICES",
        "You can use text when microphone access is denied, export individual threads, delete local " +
            "threads, and delete the separate cloud account.",
    )
    OutlinedAction("Back", actions.goNow)
}

@Composable
private fun BrandHeader(showBack: Boolean, onBack: () -> Unit, onSettings: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (showBack) {
                TextButton(onClick = onBack, modifier = Modifier.height(48.dp)) { Text("Back") }
            }
            BrandMark(MarkKind.COMPACT, Modifier.size(42.dp))
            Text(
                "Restart Thread",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
            )
        }
        TextButton(onClick = onSettings, modifier = Modifier.height(48.dp)) { Text("Settings") }
    }
    HorizontalDivider(color = Rule)
}

@Composable
private fun TactilePrimaryButton(
    label: String,
    onClick: () -> Unit,
    container: Color = ActionRed,
) {
    val interaction = remember { MutableInteractionSource() }
    val pressed by interaction.collectIsPressedAsState()
    Box(modifier = Modifier.fillMaxWidth().height(64.dp)) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(58.dp)
                .offset(y = 6.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(if (container == Ink) Color(0xFF000000) else ActionEdge),
        )
        Button(
            onClick = onClick,
            interactionSource = interaction,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .offset(y = if (pressed) 5.dp else 0.dp),
            colors = ButtonDefaults.buttonColors(containerColor = container, contentColor = Color.White),
            shape = RoundedCornerShape(12.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(Modifier.size(18.dp).background(Color.White, CircleShape))
                Text(label, fontWeight = FontWeight.SemiBold)
                Text("›", fontSize = 28.sp)
            }
        }
    }
}

@Composable
private fun OutlinedAction(label: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().height(52.dp),
        shape = RoundedCornerShape(12.dp),
    ) {
        Text(label)
    }
}

@Composable
private fun ScreenTitle(text: String) {
    Text(text, style = MaterialTheme.typography.headlineLarge, modifier = Modifier.semantics { heading() })
}

@Composable
private fun SectionLabel(text: String) {
    Text(text, color = ActionRed, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelLarge)
}

@Composable
private fun EvidenceCard(label: String, text: String) {
    Column(
        modifier = Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(10.dp)).padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        SectionLabel(label)
        Text(text, style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
private fun SourceEvidence(source: String) {
    val phrase = "cancellation fee"
    val annotated = buildAnnotatedString {
        val start = source.indexOf(phrase, ignoreCase = true)
        if (start < 0) {
            append(source)
        } else {
            append(source.substring(0, start))
            pushStyle(SpanStyle(color = ActionRed, textDecoration = TextDecoration.Underline))
            append(source.substring(start, start + phrase.length))
            pop()
            append(source.substring(start + phrase.length))
        }
    }
    Column(
        modifier = Modifier.fillMaxWidth().background(PaleRed, RoundedCornerShape(8.dp)).padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        SectionLabel("SOURCE")
        Text(annotated)
    }
}

@Composable
private fun DottedTrace() {
    Row(
        modifier = Modifier.fillMaxWidth().semantics {
            contentDescription = "The first step traces back to the saved source words"
        },
        horizontalArrangement = Arrangement.Center,
    ) {
        repeat(5) { Box(Modifier.padding(horizontal = 4.dp).size(5.dp).background(ActionRed, CircleShape)) }
    }
}

@Composable
private fun ThreadRow(thread: RecoveryThread, onOpen: (String) -> Unit) {
    TextButton(onClick = { onOpen(thread.id) }, modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(thread.proposedAction, color = Ink, fontWeight = FontWeight.SemiBold)
            Text(thread.capturedText, color = Gray, maxLines = 2)
        }
    }
    HorizontalDivider(color = Rule)
}

@Composable
private fun SettingsSection(label: String, content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        SectionLabel(label)
        content()
        HorizontalDivider(color = Rule)
    }
}

@Composable
private fun SwitchCurrentDialog(current: RecoveryThread?, actions: RestartThreadUiActions) {
    AlertDialog(
        onDismissRequest = actions.dismissCurrentSwitch,
        title = { Text("Move to a different thread?") },
        text = {
            Text(
                "Only one thread can be current. “${current?.proposedAction.orEmpty()}” will not be replaced silently.",
            )
        },
        confirmButton = {
            TextButton(onClick = { actions.resolveCurrentThread(SwitchCurrentChoice.COMPLETE) }) {
                Text("Complete and continue")
            }
        },
        dismissButton = {
            Column {
                TextButton(onClick = { actions.resolveCurrentThread(SwitchCurrentChoice.ARCHIVE) }) {
                    Text("Archive and continue")
                }
                TextButton(onClick = actions.dismissCurrentSwitch) { Text("Cancel") }
            }
        },
    )
}

private enum class MarkKind { OPEN, COMPACT }

@Composable
private fun BrandMark(kind: MarkKind, modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.semantics { contentDescription = "Restart Thread" }) {
        withTransform({ scale(size.width / 256f, size.height / 256f) }) {
            when (kind) {
                MarkKind.OPEN -> drawOpenMark(Ink)
                MarkKind.COMPACT -> drawCompactMark(Ink)
            }
        }
    }
}

private fun DrawScope.drawOpenMark(color: Color) {
    drawPath(
        Path().apply {
            moveTo(110f, 42f); lineTo(80f, 42f); cubicTo(52f, 42f, 38f, 58f, 38f, 86f)
            lineTo(38f, 108f); lineTo(62f, 108f); lineTo(62f, 86f)
            cubicTo(62f, 73f, 67f, 66f, 80f, 66f); lineTo(110f, 66f); close()
        },
        color,
    )
    drawPath(
        Path().apply {
            moveTo(38f, 148f); lineTo(38f, 170f); cubicTo(38f, 198f, 52f, 214f, 80f, 214f)
            lineTo(110f, 214f); lineTo(110f, 190f); lineTo(80f, 190f)
            cubicTo(67f, 190f, 62f, 183f, 62f, 170f); lineTo(62f, 148f); close()
        },
        color,
    )
    listOf(22f, 46f, 70f, 94f).forEach { drawCircle(color, 7f, androidx.compose.ui.geometry.Offset(it, 128f)) }
    drawCircle(color, 34f, androidx.compose.ui.geometry.Offset(148f, 128f))
    drawPath(
        Path().apply {
            moveTo(198f, 85f); cubicTo(194f, 82f, 189f, 85f, 189f, 90f)
            lineTo(189f, 166f); cubicTo(189f, 171f, 194f, 174f, 198f, 171f)
            lineTo(236f, 135f); cubicTo(240f, 131f, 240f, 125f, 236f, 121f); close()
        },
        color,
    )
}

private fun DrawScope.drawCompactMark(color: Color) {
    drawCircle(color, 9f, androidx.compose.ui.geometry.Offset(50f, 128f))
    drawCircle(color, 9f, androidx.compose.ui.geometry.Offset(80f, 128f))
    drawCircle(color, 38f, androidx.compose.ui.geometry.Offset(146f, 128f))
    drawPath(
        Path().apply {
            moveTo(204f, 83f); cubicTo(199f, 79f, 193f, 83f, 193f, 89f)
            lineTo(193f, 167f); cubicTo(193f, 173f, 199f, 177f, 204f, 173f)
            lineTo(243f, 136f); cubicTo(248f, 132f, 248f, 124f, 243f, 120f); close()
        },
        color,
    )
}

private fun Modifier.alignStart(): Modifier = this
