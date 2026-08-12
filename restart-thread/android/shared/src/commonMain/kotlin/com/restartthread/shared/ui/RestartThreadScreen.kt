package com.restartthread.shared.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.restartthread.shared.billing.SubscriptionUiState
import com.restartthread.shared.presentation.MainUiState
import com.restartthread.shared.presentation.Phase

private val Paper = Color(0xFFF7F2E8)
private val Ink = Color(0xFF20312D)
private val Signal = Color(0xFFC44332)
private val Muted = Color(0xFF64706C)

@Composable
fun RestartThreadScreen(
    state: MainUiState,
    subscriptionState: SubscriptionUiState = SubscriptionUiState(),
    onUpgrade: (() -> Unit)? = null,
    onManageSubscription: (() -> Unit)? = null,
    onInput: (String) -> Unit,
    onSave: () -> Unit,
    onVoice: () -> Unit,
    onAction: (String) -> Unit,
    onStart: () -> Unit,
    onReset: () -> Unit,
) {
    MaterialTheme {
        Surface(color = Paper, contentColor = Ink, modifier = Modifier.fillMaxSize()) {
            BoxWithConstraints(Modifier.fillMaxSize()) {
                val horizontalPadding = if (maxWidth >= 600.dp) 48.dp else 24.dp
                Column(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .fillMaxSize()
                        .widthIn(max = 680.dp)
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = horizontalPadding, vertical = 28.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                ) {
                    BrandHeader(onManageSubscription)
                    when (state.phase) {
                        Phase.CAPTURE -> CaptureScreen(state, onInput, onSave, onVoice)
                        Phase.REVIEW -> ReviewScreen(state, onAction, onStart, onReset)
                        Phase.STARTED -> StartedScreen(
                            action = state.action,
                            subscriptionState = subscriptionState,
                            onUpgrade = onUpgrade,
                            onReset = onReset,
                        )
                    }
                    state.message?.let {
                        Text(it, color = Muted, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}

@Composable
private fun BrandHeader(onManageSubscription: (() -> Unit)?) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                Modifier
                    .size(20.dp)
                    .background(Signal, CircleShape)
                    .semantics { contentDescription = "Present state" },
            )
            Text(" · · · → ", color = Ink, fontWeight = FontWeight.Bold)
            Text(
                "Restart Thread",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
            )
        }
        onManageSubscription?.let {
            TextButton(onClick = it) {
                Text("Manage Pro")
            }
        }
    }
}

@Composable
private fun CaptureScreen(
    state: MainUiState,
    onInput: (String) -> Unit,
    onSave: () -> Unit,
    onVoice: () -> Unit,
) {
    Text(
        "Where were you?",
        style = MaterialTheme.typography.headlineLarge,
        fontWeight = FontWeight.Bold,
    )
    Text(
        "Say or type what is true right now. It saves on this device before anything else happens.",
        color = Muted,
    )
    OutlinedTextField(
        value = state.input,
        onValueChange = onInput,
        modifier = Modifier.fillMaxWidth(),
        minLines = 5,
        label = { Text("Current state") },
        placeholder = { Text("I was working on… The part blocking me is…") },
    )
    Button(
        onClick = onSave,
        modifier = Modifier.fillMaxWidth().height(56.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Ink, contentColor = Paper),
        shape = RoundedCornerShape(14.dp),
    ) {
        Text("Save and find a first step")
    }
    OutlinedButton(
        onClick = onVoice,
        modifier = Modifier.fillMaxWidth().height(56.dp),
        shape = RoundedCornerShape(14.dp),
    ) {
        Text(if (state.isRecording) "Stop and save voice note" else "Record a voice note")
    }
}

@Composable
private fun ReviewScreen(
    state: MainUiState,
    onAction: (String) -> Unit,
    onStart: () -> Unit,
    onReset: () -> Unit,
) {
    Text("Start here", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold)
    Column(
        Modifier
            .fillMaxWidth()
            .background(Color.White.copy(alpha = 0.62f), RoundedCornerShape(18.dp))
            .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Text("YOU SAID", color = Signal, fontWeight = FontWeight.Bold)
        Text(state.evidence)
    }
    OutlinedTextField(
        value = state.action,
        onValueChange = onAction,
        modifier = Modifier.fillMaxWidth(),
        minLines = 3,
        label = { Text("Editable first step") },
        supportingText = { Text("You stay in control. Nothing starts automatically.") },
    )
    Button(
        onClick = onStart,
        modifier = Modifier.fillMaxWidth().height(56.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Signal, contentColor = Color.White),
        shape = RoundedCornerShape(14.dp),
    ) {
        Text("Start this step →")
    }
    OutlinedButton(onClick = onReset, modifier = Modifier.fillMaxWidth()) {
        Text("Save and return later")
    }
}

@Composable
private fun StartedScreen(
    action: String,
    subscriptionState: SubscriptionUiState,
    onUpgrade: (() -> Unit)?,
    onReset: () -> Unit,
) {
    Spacer(Modifier.height(40.dp))
    Text(
        "You moved it forward.",
        style = MaterialTheme.typography.headlineLarge,
        fontWeight = FontWeight.Bold,
    )
    Text(action, style = MaterialTheme.typography.titleLarge)
    Text("This is a verified restart—not just an app open.", color = Muted)
    when {
        subscriptionState.isPro -> Text("Restart Thread Pro is active.", color = Muted)
        onUpgrade != null -> OutlinedButton(
            onClick = onUpgrade,
            modifier = Modifier.fillMaxWidth().height(56.dp),
            shape = RoundedCornerShape(14.dp),
        ) {
            Text("Explore Restart Thread Pro")
        }
        subscriptionState.isConfigured && !subscriptionState.isLoading -> {
            subscriptionState.statusMessage?.let {
                Text(it, color = Muted, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
    Button(
        onClick = onReset,
        modifier = Modifier.fillMaxWidth().height(56.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Ink, contentColor = Paper),
    ) {
        Text("Capture another thread")
    }
}
