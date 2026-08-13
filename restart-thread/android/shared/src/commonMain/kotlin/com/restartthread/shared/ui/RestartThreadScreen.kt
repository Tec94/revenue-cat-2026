package com.restartthread.shared.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.windowInsetsPadding
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
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.liveRegion
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
private val White = Color(0xFFFFFFFF)
private val DarkPaper = Color(0xFF0D0D0D)
private val DarkSurface = Color(0xFF181818)
private val DarkRule = Color(0xFF383838)
private val DarkAccent = Color(0xFFFF8298)

private val LightColors = lightColorScheme(
    primary = ActionRed,
    onPrimary = White,
    primaryContainer = ActionEdge,
    onPrimaryContainer = White,
    secondary = Ink,
    onSecondary = Paper,
    secondaryContainer = Color.Black,
    onSecondaryContainer = Paper,
    background = Paper,
    onBackground = Ink,
    surface = White,
    onSurface = Ink,
    surfaceVariant = Color(0xFFF1EEE7),
    onSurfaceVariant = Gray,
    outline = Color(0xFFD8D5CF),
    error = Color(0xFFB3261E),
)

private val DarkColors = darkColorScheme(
    primary = DarkAccent,
    onPrimary = Color(0xFF3A0010),
    primaryContainer = Color(0xFF7A1230),
    onPrimaryContainer = White,
    secondary = Paper,
    onSecondary = Ink,
    secondaryContainer = Color(0xFFC7C4BC),
    onSecondaryContainer = Ink,
    background = DarkPaper,
    onBackground = Paper,
    surface = DarkSurface,
    onSurface = Paper,
    surfaceVariant = Color(0xFF242424),
    onSurfaceVariant = Color(0xFFC9C6C0),
    outline = DarkRule,
    error = Color(0xFFFF8A80),
)

private val RestartTypography = Typography(
    displayLarge = Typography().displayLarge.copy(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Bold,
        fontSize = 42.sp,
        lineHeight = 46.sp,
        letterSpacing = (-0.6).sp,
    ),
    headlineLarge = Typography().headlineLarge.copy(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
        lineHeight = 38.sp,
        letterSpacing = (-0.35).sp,
    ),
    headlineMedium = Typography().headlineMedium.copy(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 33.sp,
    ),
    titleLarge = Typography().titleLarge.copy(
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 27.sp,
    ),
    titleMedium = Typography().titleMedium.copy(
        fontWeight = FontWeight.SemiBold,
        fontSize = 17.sp,
        lineHeight = 24.sp,
    ),
    bodyLarge = Typography().bodyLarge.copy(fontSize = 17.sp, lineHeight = 27.sp),
    bodyMedium = Typography().bodyMedium.copy(fontSize = 15.sp, lineHeight = 23.sp),
    bodySmall = Typography().bodySmall.copy(fontSize = 13.sp, lineHeight = 19.sp),
    labelLarge = Typography().labelLarge.copy(
        fontWeight = FontWeight.SemiBold,
        fontSize = 15.sp,
        lineHeight = 20.sp,
    ),
    labelMedium = Typography().labelMedium.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 17.sp,
        letterSpacing = 0.5.sp,
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
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) DarkColors else LightColors,
        typography = RestartTypography,
    ) {
        Surface(
            color = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.fillMaxSize(),
        ) {
            BoxWithConstraints(Modifier.fillMaxSize()) {
                val horizontalPadding = when {
                    maxWidth >= 840.dp -> 48.dp
                    maxWidth >= 600.dp -> 32.dp
                    else -> 20.dp
                }
                Column(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .fillMaxSize()
                        .widthIn(max = 720.dp)
                        .windowInsetsPadding(WindowInsets.safeDrawing)
                        .imePadding()
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = horizontalPadding, vertical = 12.dp),
                ) {
                    if (state.route !in setOf(AppRoute.BOOTSTRAP, AppRoute.WELCOME)) {
                        BrandHeader(
                            showBack = state.route == AppRoute.DATA_PRIVACY ||
                                state.onboardingComplete && state.route !in setOf(
                                    AppRoute.NOW,
                                    AppRoute.ACCOUNT_OFFER,
                                ),
                            showSettings = state.onboardingComplete && state.route !in setOf(
                                AppRoute.SETTINGS,
                                AppRoute.DATA_PRIVACY,
                            ),
                            onBack = actions.goBack,
                            onSettings = actions.showSettings,
                        )
                        Spacer(Modifier.height(28.dp))
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
                        Spacer(Modifier.height(20.dp))
                        StatusBanner(it)
                    }
                    Spacer(Modifier.height(36.dp))
                }

                if (state.showSwitchCurrent) SwitchCurrentDialog(state.currentThread, actions)
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
            authState,
            microphonePermission,
            subscriptionState,
            onUpgrade,
            onManageSubscription,
            actions,
        )
        AppRoute.DATA_PRIVACY -> DataPrivacyScreen(actions)
    }
}

@Composable
private fun BootstrapScreen() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 104.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(18.dp),
    ) {
        BrandMark(Modifier.size(112.dp))
        Text("Restart Thread", style = MaterialTheme.typography.headlineLarge)
    }
}

@Composable
private fun WelcomeScreen(actions: RestartThreadUiActions) = ScreenColumn(topPadding = 28.dp) {
    BrandMark(Modifier.size(118.dp).align(Alignment.CenterHorizontally))
    PageIntro(
        eyebrow = "A clear place to restart",
        title = "Say where you are. Start again from one clear step.",
        body = "Leave a thread in your own words. It stays on this device and gives you one place to begin.",
        display = true,
    )
    PrivacyNote("No account or microphone permission is needed to begin.")
    ActionGroup {
        TactilePrimaryButton("Leave my first thread", actions.leaveFirstThread)
        SecondaryAction("Try the 20-second example", actions.tryExample)
        TertiaryAction("Sign in", actions.showAccountOffer)
        TertiaryAction("How your data stays local", actions.showDataPrivacy)
    }
}

@Composable
private fun CaptureScreen(state: MainUiState, actions: RestartThreadUiActions) = ScreenColumn {
    PageIntro(
        eyebrow = "Leave a thread",
        title = "Where were you?",
        body = "Say or type what is true right now. Your words save on this device before anything else happens.",
    )
    ContentCard {
        OutlinedTextField(
            value = state.input,
            onValueChange = actions.setInput,
            modifier = Modifier.fillMaxWidth(),
            minLines = 5,
            label = { Text("Current state") },
            placeholder = { Text("I was working on… The part blocking me is…") },
        )
        CaptureProgressLabel(state.captureProgress)
    }
    ActionGroup {
        TactilePrimaryButton("Save and find a first step", actions.saveText, ink = true)
        SecondaryAction(
            if (state.isRecording) "Stop and save voice note" else "Record a voice note",
            actions.voice,
        )
    }
    SupportingText("Voice and text are equal routes. Microphone access is requested only after you choose voice.")
}

@Composable
private fun ReviewScreen(state: MainUiState, actions: RestartThreadUiActions, isExample: Boolean) = ScreenColumn {
    val whyVisible = remember(state.route, state.threadId) { mutableStateOf(false) }
    if (isExample) StatusPill("20-second example")
    PageIntro(
        eyebrow = if (isExample) "Try the core loop" else "Your first step",
        title = "Start here",
        body = if (isExample) {
            "This example is temporary. Change the first step or start it as written."
        } else {
            "Keep the step small and specific. You can change the draft before anything starts."
        },
    )
    CaptureProgressLabel(state.captureProgress)
    EvidenceCard("You said", state.input.ifBlank { state.evidence })
    DottedTrace()
    ContentCard {
        OutlinedTextField(
            value = state.action,
            onValueChange = actions.setAction,
            modifier = Modifier.fillMaxWidth(),
            minLines = 3,
            label = { Text("Editable first step") },
            supportingText = {
                Text(
                    if (state.isAiGenerated) "AI draft. You decide what to keep and when to start."
                    else "You decide what to keep and when to start.",
                )
            },
        )
    }
    ActionGroup {
        TactilePrimaryButton("Start this step", actions.confirmStart)
        SecondaryAction(
            if (whyVisible.value) "Hide source" else "Why this step?",
            { whyVisible.value = !whyVisible.value },
        )
        if (!isExample) TertiaryAction("Save and return later", actions.goNow)
    }
    if (whyVisible.value) {
        DottedTrace()
        SourceEvidence(state.evidence)
    }
    if (isExample) SupportingText("The example is discarded after you start. It never enters your history.")
}

@Composable
private fun StartedScreen(state: MainUiState, actions: RestartThreadUiActions) = ScreenColumn {
    StatusPill("Restart started")
    PageIntro(
        eyebrow = "Progress you can verify",
        title = "You moved it forward.",
        body = "This restart is tied to the step you chose—not just an app open.",
    )
    FocusCard(label = "Started step", text = state.action)
    ActionGroup {
        TactilePrimaryButton("Back to Now", actions.finishStarted, ink = true)
        SecondaryAction("Leave a new stopping point", actions.leaveNewStoppingPoint)
        TertiaryAction("Mark thread complete", actions.markCurrentComplete)
        TertiaryAction("Archive thread", actions.archiveCurrent)
    }
}

@Composable
private fun AccountOfferScreen(authState: AuthUiState, actions: RestartThreadUiActions) = ScreenColumn {
    PageIntro(
        eyebrow = "Optional account",
        title = "Keep Pro and cloud access with you.",
        body = "An account links Pro, cloud allowance, web purchases, and future referrals. Thread text and audio remain on this device.",
    )
    ContentCard {
        BenefitLine("Use the same Pro entitlement after sign-in.")
        BenefitLine("Keep local threads separate from account data.")
        BenefitLine("Continue without an account at any time.")
    }
    if (authState.isAuthenticated) {
        FocusCard("Signed in", authState.displayName ?: "Your account is connected.")
        TactilePrimaryButton("Continue to Now", actions.completeAccountStep)
    } else {
        ActionGroup {
            TactilePrimaryButton(
                if (authState.isLoading) "Opening secure sign-in…" else "Create or sign in",
                actions.signIn,
            )
            SecondaryAction("Continue without an account", actions.completeAccountStep)
        }
    }
    if (!authState.isConfigured) {
        PrivacyNote("Sign-in is not configured yet. Local use is available now.")
    }
    authState.message?.let { SupportingText(it) }
}

@Composable
private fun NowScreen(state: MainUiState, actions: RestartThreadUiActions) = ScreenColumn {
    PageIntro(
        eyebrow = "Your current place",
        title = "Now",
        body = "Return to one thread or leave a clear stopping point for later.",
    )
    val current = state.currentThread
    if (current == null) {
        EmptyStateCard(
            title = "Nothing is waiting here",
            body = "Leave where you are so one clear step is ready when you return.",
            action = "Leave a thread",
            onAction = actions.startNewThread,
        )
    } else {
        ReturnCard(current, actions)
        SecondaryAction("Update stopping point", actions.leaveNewStoppingPoint)
    }

    val recents = state.threads
        .filter { it.status != ThreadStatus.DELETED && it.id != current?.id }
        .take(3)
    if (recents.isNotEmpty()) {
        SectionHeading("Recent threads")
        ThreadListCard(recents, actions.openThread)
    }
    ActionGroup {
        SecondaryAction("View all threads", actions.showAllThreads)
        TertiaryAction("Open settings", actions.showSettings)
    }
}

@Composable
private fun ReturnCard(thread: RecoveryThread, actions: RestartThreadUiActions) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(22.dp))
            .padding(22.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            "Return to thread",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelLarge,
        )
        Text(
            thread.capturedText,
            color = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.78f),
            style = MaterialTheme.typography.bodyLarge,
        )
        HorizontalDivider(color = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.2f))
        Text(
            thread.proposedAction,
            color = MaterialTheme.colorScheme.onSecondary,
            style = MaterialTheme.typography.titleLarge,
        )
        Button(
            onClick = { actions.openThread(thread.id) },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
            ),
            modifier = Modifier.fillMaxWidth().heightIn(min = 52.dp),
            shape = RoundedCornerShape(12.dp),
        ) {
            Text("Return to thread")
        }
    }
}

@Composable
private fun AllThreadsScreen(state: MainUiState, actions: RestartThreadUiActions) = ScreenColumn {
    PageIntro(
        eyebrow = "Local history",
        title = "All threads",
        body = "Search the words you saved or the first step you chose.",
    )
    OutlinedTextField(
        value = state.searchQuery,
        onValueChange = actions.setSearchQuery,
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Search threads") },
        placeholder = { Text("Words or first step") },
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
        EmptyStateCard(
            title = if (query.isBlank()) "No saved threads" else "No matching threads",
            body = if (query.isBlank()) {
                "Threads appear here after you save a stopping point."
            } else {
                "Try a different word from your stopping point or first step."
            },
        )
    } else {
        ThreadStatus.entries.filter { it != ThreadStatus.DELETED }.forEach { status ->
            val section = visible.filter { it.status == status }
            if (section.isNotEmpty()) {
                SectionHeading(status.displayName())
                ThreadListCard(section, actions.openThread)
            }
        }
    }
    SettingsActionRow(
        title = "Recently deleted",
        supporting = "Restore a thread or remove it permanently.",
        onClick = actions.showRecentlyDeleted,
    )
}

@Composable
private fun ThreadDetailScreen(state: MainUiState, actions: RestartThreadUiActions) = ScreenColumn {
    val thread = state.selectedThread
    if (thread == null) {
        EmptyStateCard("Thread unavailable", "Return to your local history and choose another thread.")
        return@ScreenColumn
    }
    StatusPill(thread.status.displayName())
    PageIntro(
        eyebrow = "Saved thread",
        title = "Thread detail",
        body = "Review the saved context and the step you chose.",
    )
    EvidenceCard("You said", thread.capturedText)
    FocusCard("Start here", thread.proposedAction)
    SettingsCard("Thread actions") {
        SettingsActionRow("Edit stopping point", "Change the saved context and first step.", actions.editSelectedThread)
        if (thread.status == ThreadStatus.ACTIVE) {
            SettingsActionRow("Return to thread", "Open the saved first step.", actions.returnToSelectedThread)
            SettingsActionRow("Mark complete", "Move this thread out of Now.", actions.completeSelectedThread)
        }
        SettingsActionRow("Archive thread", "Keep it in history without making it current.", actions.archiveSelectedThread)
        SettingsActionRow("Export thread", "Share a readable copy from this device.", actions.exportSelectedThread)
        SettingsActionRow("Delete thread", "Move it to Recently deleted.", actions.deleteSelectedThread, destructive = true)
    }
}

@Composable
private fun RecentlyDeletedScreen(state: MainUiState, actions: RestartThreadUiActions) = ScreenColumn {
    PageIntro(
        eyebrow = "Local recovery",
        title = "Recently deleted",
        body = "Deleted threads remain here until you restore or permanently delete them.",
    )
    val deleted = state.threads.filter { it.status == ThreadStatus.DELETED }
    if (deleted.isEmpty()) {
        EmptyStateCard("Nothing is deleted", "Threads that you delete will appear here.")
    } else {
        deleted.forEach { thread ->
            ContentCard {
                Text(thread.proposedAction, style = MaterialTheme.typography.titleMedium)
                SupportingText(thread.capturedText, maxLines = 3)
                SecondaryAction("Restore thread", { actions.restoreThread(thread.id) })
                TertiaryAction(
                    "Delete permanently",
                    { actions.permanentlyDeleteThread(thread.id) },
                    destructive = true,
                )
            }
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
) = ScreenColumn {
    val confirmLocalDelete = remember { mutableStateOf(false) }
    val confirmCloudDelete = remember { mutableStateOf(false) }
    PageIntro(
        eyebrow = "Preferences and access",
        title = "Settings",
        body = "Manage your account, Pro access, local data, and Android surfaces.",
    )

    SettingsCard(
        title = "Account",
        summary = when {
            authState.isAuthenticated -> authState.displayName ?: "Signed in"
            authState.isConfigured -> "Using Restart Thread without an account"
            else -> "Local-only use"
        },
        badge = if (authState.isAuthenticated) "Connected" else "Optional",
    ) {
        if (!authState.isConfigured) {
            SupportingText("Auth0 is not configured. You can continue to use local threads.")
        }
        if (authState.isAuthenticated) {
            SettingsActionRow("Sign out", "Keep local threads on this device.", actions.signOut)
            SettingsActionRow(
                "Delete cloud account",
                "Remove account access and cloud allowance data.",
                { confirmCloudDelete.value = true },
                destructive = true,
            )
        } else {
            SettingsActionRow("Create or sign in", "Link Pro and cloud allowance to your account.", actions.signIn)
        }
    }

    SettingsCard(
        title = "Restart Thread Pro",
        summary = if (subscriptionState.isPro) "Pro is active" else "Free plan",
        badge = if (subscriptionState.isPro) "Active" else null,
    ) {
        when {
            subscriptionState.isPro && onManageSubscription != null -> SettingsActionRow(
                "Manage subscription",
                "Open Customer Center for billing and cancellation options.",
                onManageSubscription,
            )
            onUpgrade != null -> SettingsActionRow(
                "Explore Pro",
                "Compare the available monthly and yearly plans.",
                onUpgrade,
            )
        }
        SettingsActionRow("Restore purchases", "Check this store account for active purchases.", actions.restorePurchases)
        subscriptionState.statusMessage?.let { SupportingText(it) }
    }

    SettingsCard(
        title = "Voice and AI",
        summary = "Thread text and audio stay encrypted on this device.",
        badge = if (microphonePermission == MicrophonePermissionState.GRANTED) "Microphone on" else "Microphone off",
    ) {
        SettingsActionRow(
            title = "Microphone permission",
            supporting = if (microphonePermission == MicrophonePermissionState.GRANTED) {
                "Voice capture is available."
            } else {
                "Text capture remains fully available."
            },
            onClick = actions.openMicrophoneSettings,
        )
    }

    SettingsCard(
        title = "Data",
        summary = "Local threads and cloud account data are separate.",
    ) {
        SettingsActionRow("Privacy and local data", "See what stays local and what an account links.", actions.showDataPrivacy)
        SupportingText("Export is available from each thread.")
        SettingsActionRow(
            "Delete all local threads",
            "Move every local thread to Recently deleted.",
            { confirmLocalDelete.value = true },
            destructive = true,
        )
    }

    SettingsCard(
        title = "Home widget",
        summary = "Return to the current thread from the Android home screen.",
        badge = "Android",
    ) {
        SettingsActionRow(
            "Add home widget",
            "The widget can show your current first step. Add it only where that is private enough.",
            actions.requestWidgetPin,
        )
    }

    SettingsCard("About") {
        SettingsActionRow("Privacy policy", null, actions.openPrivacyPolicy)
        SettingsActionRow("Terms", null, actions.openTerms)
        SettingsActionRow("Support", null, actions.openSupport)
    }

    if (confirmLocalDelete.value) {
        AlertDialog(
            onDismissRequest = { confirmLocalDelete.value = false },
            title = { Text("Move all threads to Recently deleted?") },
            text = { Text("You can restore them later or delete them permanently.") },
            confirmButton = {
                TextButton(onClick = {
                    confirmLocalDelete.value = false
                    actions.deleteAllLocalThreads()
                }) { Text("Move all threads", color = MaterialTheme.colorScheme.error) }
            },
            dismissButton = {
                TextButton(onClick = { confirmLocalDelete.value = false }) { Text("Cancel") }
            },
        )
    }
    if (confirmCloudDelete.value) {
        AlertDialog(
            onDismissRequest = { confirmCloudDelete.value = false },
            title = { Text("Delete cloud account?") },
            text = { Text("This removes Auth0 and cloud allowance data. Local threads stay on this device.") },
            confirmButton = {
                TextButton(onClick = {
                    confirmCloudDelete.value = false
                    actions.deleteCloudAccount()
                }) { Text("Delete cloud account", color = MaterialTheme.colorScheme.error) }
            },
            dismissButton = {
                TextButton(onClick = { confirmCloudDelete.value = false }) { Text("Cancel") }
            },
        )
    }
}

@Composable
private fun DataPrivacyScreen(actions: RestartThreadUiActions) = ScreenColumn {
    PageIntro(
        eyebrow = "Privacy by default",
        title = "Your thread stays with you.",
        body = "Restart Thread saves text and voice in an encrypted vault on this device before any optional processing.",
    )
    EvidenceCard(
        "Guided example",
        "The example is disposable. It is not saved, sent, or added to your history.",
    )
    EvidenceCard(
        "Accounts",
        "Signing in links Pro and cloud allowance. It does not turn on thread sync, and the backend does not receive thread text or audio.",
    )
    EvidenceCard(
        "Your choices",
        "Use text without microphone access, export individual threads, delete local threads, or delete the separate cloud account.",
    )
    SecondaryAction("Go back", actions.goBack)
}

@Composable
private fun BrandHeader(
    showBack: Boolean,
    showSettings: Boolean,
    onBack: () -> Unit,
    onSettings: () -> Unit,
) {
    Box(modifier = Modifier.fillMaxWidth().height(56.dp)) {
        if (showBack) HeaderIconButton("Go back", onBack, Modifier.align(Alignment.CenterStart)) {
            BackIcon()
        }
        BrandMark(
            Modifier
                .align(Alignment.Center)
                .offset(x = (-1).dp)
                .size(38.dp),
        )
        if (showSettings) HeaderIconButton("Settings", onSettings, Modifier.align(Alignment.CenterEnd)) {
            SettingsIcon()
        }
    }
}

@Composable
private fun HeaderIconButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier,
    icon: @Composable BoxScope.() -> Unit,
) {
    Surface(
        onClick = onClick,
        modifier = modifier.size(48.dp).semantics { contentDescription = label },
        shape = CircleShape,
        color = MaterialTheme.colorScheme.surfaceVariant,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Box(Modifier.size(34.dp), content = icon)
        }
    }
}

@Composable
private fun BackIcon() {
    val color = MaterialTheme.colorScheme.onBackground
    Canvas(Modifier.fillMaxSize()) {
        val stroke = 2.5.dp.toPx()
        val point = Offset(size.width * 0.20f, size.height * 0.50f)
        val top = Offset(size.width * 0.50f, size.height * 0.20f)
        val bottom = Offset(size.width * 0.50f, size.height * 0.80f)
        val end = Offset(size.width * 0.80f, size.height * 0.50f)
        drawLine(color, top, point, strokeWidth = stroke, cap = StrokeCap.Round)
        drawLine(color, point, bottom, strokeWidth = stroke, cap = StrokeCap.Round)
        drawLine(color, point, end, strokeWidth = stroke, cap = StrokeCap.Round)
    }
}

@Composable
private fun SettingsIcon() {
    val color = MaterialTheme.colorScheme.onBackground
    Canvas(Modifier.fillMaxSize()) {
        val radius = size.minDimension
        val stroke = 2.dp.toPx()
        drawCircle(color, radius = radius * 0.29f, center = center, style = Stroke(width = stroke))
        drawCircle(color, radius = radius * 0.11f, center = center, style = Stroke(width = stroke))
        repeat(8) { index ->
            val angle = index * 45.0 * kotlin.math.PI / 180.0
            val start = Offset(
                center.x + (radius * 0.32f * kotlin.math.cos(angle)).toFloat(),
                center.y + (radius * 0.32f * kotlin.math.sin(angle)).toFloat(),
            )
            val end = Offset(
                center.x + (radius * 0.43f * kotlin.math.cos(angle)).toFloat(),
                center.y + (radius * 0.43f * kotlin.math.sin(angle)).toFloat(),
            )
            drawLine(color, start, end, strokeWidth = stroke, cap = StrokeCap.Round)
        }
    }
}

@Composable
private fun ScreenColumn(
    topPadding: androidx.compose.ui.unit.Dp = 0.dp,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(top = topPadding),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        content = content,
    )
}

@Composable
private fun PageIntro(
    eyebrow: String,
    title: String,
    body: String? = null,
    display: Boolean = false,
) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Eyebrow(eyebrow)
        Text(
            title,
            style = if (display) MaterialTheme.typography.displayLarge else MaterialTheme.typography.headlineLarge,
            modifier = Modifier.semantics { heading() }.widthIn(max = 640.dp),
        )
        body?.let { Text(it, color = MaterialTheme.colorScheme.onSurfaceVariant, style = MaterialTheme.typography.bodyLarge) }
    }
}

@Composable
private fun Eyebrow(text: String) {
    Text(text, color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.labelMedium)
}

@Composable
private fun SectionHeading(text: String) {
    Text(text, style = MaterialTheme.typography.titleLarge, modifier = Modifier.semantics { heading() })
}

@Composable
private fun ContentCard(content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(20.dp))
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        content = content,
    )
}

@Composable
private fun FocusCard(label: String, text: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(18.dp))
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Eyebrow(label)
        Text(text, style = MaterialTheme.typography.titleLarge)
    }
}

@Composable
private fun EvidenceCard(label: String, text: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(18.dp))
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Eyebrow(label)
        Text(text, style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
private fun EmptyStateCard(
    title: String,
    body: String,
    action: String? = null,
    onAction: (() -> Unit)? = null,
) {
    ContentCard {
        Text(title, style = MaterialTheme.typography.titleLarge)
        SupportingText(body)
        if (action != null && onAction != null) TactilePrimaryButton(action, onAction)
    }
}

@Composable
private fun PrivacyNote(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(14.dp))
            .padding(horizontal = 16.dp, vertical = 14.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(Modifier.size(10.dp).background(MaterialTheme.colorScheme.primary, CircleShape))
        Text(text, color = MaterialTheme.colorScheme.onSurfaceVariant, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
private fun StatusBanner(text: String) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant,
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier.fillMaxWidth().semantics { liveRegion = LiveRegionMode.Polite },
    ) {
        Text(text, modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
private fun StatusPill(text: String) {
    Surface(color = MaterialTheme.colorScheme.surfaceVariant, shape = CircleShape) {
        Text(
            text,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelMedium,
        )
    }
}

@Composable
private fun BenefitLine(text: String) {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.Top) {
        Box(Modifier.padding(top = 8.dp).size(8.dp).background(MaterialTheme.colorScheme.primary, CircleShape))
        Text(text, modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
private fun ActionGroup(content: @Composable ColumnScope.() -> Unit) {
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp), content = content)
}

@Composable
private fun TactilePrimaryButton(label: String, onClick: () -> Unit, ink: Boolean = false) {
    val interaction = remember { MutableInteractionSource() }
    val pressed by interaction.collectIsPressedAsState()
    val colors = MaterialTheme.colorScheme
    val container = if (ink) colors.secondary else colors.primary
    val content = if (ink) colors.onSecondary else colors.onPrimary
    val edge = if (ink) colors.secondaryContainer else colors.primaryContainer
    Box(modifier = Modifier.fillMaxWidth().padding(bottom = 6.dp)) {
        Box(
            Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(58.dp)
                .offset(y = 6.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(edge),
        )
        Button(
            onClick = onClick,
            interactionSource = interaction,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 58.dp)
                .scale(if (pressed) 0.96f else 1f),
            colors = ButtonDefaults.buttonColors(containerColor = container, contentColor = content),
            shape = RoundedCornerShape(14.dp),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 18.dp, vertical = 14.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(Modifier.size(18.dp).background(content, CircleShape))
                Text(label, modifier = Modifier.padding(horizontal = 12.dp), style = MaterialTheme.typography.labelLarge)
                ForwardArrow(content)
            }
        }
    }
}

@Composable
private fun ForwardArrow(color: Color) {
    Canvas(Modifier.size(20.dp)) {
        drawLine(color, Offset(4f, 10f), Offset(16f, 10f), strokeWidth = 2.3f, cap = StrokeCap.Round)
        drawLine(color, Offset(11f, 5f), Offset(16f, 10f), strokeWidth = 2.3f, cap = StrokeCap.Round)
        drawLine(color, Offset(11f, 15f), Offset(16f, 10f), strokeWidth = 2.3f, cap = StrokeCap.Round)
    }
}

@Composable
private fun SecondaryAction(label: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().heightIn(min = 54.dp),
        shape = RoundedCornerShape(14.dp),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 18.dp, vertical = 13.dp),
    ) { Text(label, style = MaterialTheme.typography.labelLarge) }
}

@Composable
private fun TertiaryAction(label: String, onClick: () -> Unit, destructive: Boolean = false) {
    TextButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().heightIn(min = 48.dp),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 16.dp, vertical = 12.dp),
    ) {
        Text(
            label,
            color = if (destructive) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.labelLarge,
        )
    }
}

@Composable
private fun SupportingText(text: String, maxLines: Int = Int.MAX_VALUE) {
    Text(
        text,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        style = MaterialTheme.typography.bodyMedium,
        maxLines = maxLines,
    )
}

@Composable
private fun CaptureProgressLabel(progress: CaptureProgress) {
    val label = when (progress) {
        CaptureProgress.IDLE -> return
        CaptureProgress.SAVING -> "Saving locally…"
        CaptureProgress.SAVED -> "Saved locally"
        CaptureProgress.TRANSCRIBING -> "Transcribing voice note…"
        CaptureProgress.DRAFTING -> "Drafting a first step…"
        CaptureProgress.PARTIAL_SUCCESS -> "Saved locally. Part of the draft needs attention."
        CaptureProgress.VOICE_ONLY -> "Voice note saved locally. Transcription is not available yet."
        CaptureProgress.FAILED -> "Not saved yet"
    }
    PrivacyNote(label)
}

@Composable
private fun SourceEvidence(source: String) {
    val phrase = "cancellation fee"
    val primary = MaterialTheme.colorScheme.primary
    val annotated = buildAnnotatedString {
        val start = source.indexOf(phrase, ignoreCase = true)
        if (start < 0) {
            append(source)
        } else {
            append(source.substring(0, start))
            pushStyle(SpanStyle(color = primary, textDecoration = TextDecoration.Underline))
            append(source.substring(start, start + phrase.length))
            pop()
            append(source.substring(start + phrase.length))
        }
    }
    ContentCard {
        Eyebrow("Source words")
        Text(annotated, style = MaterialTheme.typography.bodyLarge)
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
        repeat(5) {
            Box(
                Modifier
                    .padding(horizontal = 4.dp)
                    .size(if (it == 2) 8.dp else 5.dp)
                    .background(MaterialTheme.colorScheme.primary, CircleShape),
            )
        }
    }
}

@Composable
private fun ThreadListCard(threads: List<RecoveryThread>, onOpen: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.surface, RoundedCornerShape(18.dp)),
    ) {
        threads.forEachIndexed { index, thread ->
            ThreadRow(thread, onOpen)
            if (index != threads.lastIndex) {
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 18.dp),
                    color = MaterialTheme.colorScheme.outline,
                )
            }
        }
    }
}

@Composable
private fun ThreadRow(thread: RecoveryThread, onOpen: (String) -> Unit) {
    Surface(
        onClick = { onOpen(thread.id) },
        color = Color.Transparent,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 18.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(Modifier.size(10.dp).background(MaterialTheme.colorScheme.primary, CircleShape))
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                Text(thread.proposedAction, style = MaterialTheme.typography.titleMedium)
                SupportingText(thread.capturedText, maxLines = 2)
            }
            ForwardArrow(MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Composable
private fun SettingsCard(
    title: String,
    summary: String? = null,
    badge: String? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(20.dp))
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
        ) {
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(5.dp)) {
                Text(title, style = MaterialTheme.typography.titleLarge, modifier = Modifier.semantics { heading() })
                summary?.let { SupportingText(it) }
            }
            if (badge != null) {
                Spacer(Modifier.size(12.dp))
                StatusPill(badge)
            }
        }
        content()
    }
}

@Composable
private fun SettingsActionRow(
    title: String,
    supporting: String?,
    onClick: () -> Unit,
    destructive: Boolean = false,
) {
    Surface(
        onClick = onClick,
        color = MaterialTheme.colorScheme.surfaceVariant,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().heightIn(min = 56.dp).padding(horizontal = 16.dp, vertical = 13.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                Text(
                    title,
                    color = if (destructive) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.labelLarge,
                )
                supporting?.let { SupportingText(it) }
            }
            ForwardArrow(
                if (destructive) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

@Composable
private fun SwitchCurrentDialog(current: RecoveryThread?, actions: RestartThreadUiActions) {
    AlertDialog(
        onDismissRequest = actions.dismissCurrentSwitch,
        title = { Text("Choose what happens to the current thread") },
        text = {
            Text(
                "Only one thread can be current. “${current?.proposedAction.orEmpty()}” will not be replaced without your choice.",
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

@Composable
private fun BrandMark(modifier: Modifier = Modifier) {
    val color = MaterialTheme.colorScheme.onBackground
    Canvas(modifier = modifier.semantics { contentDescription = "Restart Thread" }) {
        withTransform({
            scale(
                scaleX = size.width / 256f,
                scaleY = size.height / 256f,
                pivot = Offset.Zero,
            )
        }) {
            drawOpenMark(color)
        }
    }
}

// Canonical geometry from design/assets/logos/mark-01-open-thread.svg.
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
    listOf(22f, 46f, 70f, 94f).forEach { drawCircle(color, 7f, Offset(it, 128f)) }
    drawCircle(color, 34f, Offset(148f, 128f))
    drawPath(
        Path().apply {
            moveTo(198f, 85f); cubicTo(194f, 82f, 189f, 85f, 189f, 90f)
            lineTo(189f, 166f); cubicTo(189f, 171f, 194f, 174f, 198f, 171f)
            lineTo(236f, 135f); cubicTo(240f, 131f, 240f, 125f, 236f, 121f); close()
        },
        color,
    )
}

private fun ThreadStatus.displayName(): String = when (this) {
    ThreadStatus.ACTIVE -> "Current"
    ThreadStatus.COMPLETED -> "Completed"
    ThreadStatus.ARCHIVED -> "Archived"
    ThreadStatus.DELETED -> "Deleted"
}
