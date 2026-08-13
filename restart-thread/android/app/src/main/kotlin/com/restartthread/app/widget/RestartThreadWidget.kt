package com.restartthread.app.widget

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.LocalSize
import androidx.glance.Button
import androidx.glance.action.ActionParameters
import androidx.glance.action.actionParametersOf
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.provideContent
import androidx.glance.appwidget.updateAll
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.size
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import com.restartthread.app.MainActivity
import com.restartthread.app.R
import com.restartthread.app.data.local.EncryptedThreadVault
import com.restartthread.shared.domain.RecoveryThread
import com.restartthread.shared.domain.ThreadStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class RestartThreadWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        val current = EncryptedThreadVault(context).listThreads()
            .firstOrNull { it.status == ThreadStatus.ACTIVE }
        provideContent { WidgetContent(current) }
    }

    companion object {
        const val EXTRA_ROUTE = "restart_thread_route"
        const val EXTRA_THREAD_ID = "restart_thread_id"

        fun requestPin(context: Context): Boolean {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return false
            val manager = AppWidgetManager.getInstance(context)
            if (!manager.isRequestPinAppWidgetSupported) return false
            return manager.requestPinAppWidget(
                ComponentName(context, RestartThreadWidgetReceiver::class.java),
                null,
                null,
            )
        }

        fun refresh(context: Context) {
            CoroutineScope(SupervisorJob() + Dispatchers.IO).launch {
                RestartThreadWidget().updateAll(context)
            }
        }
    }
}

class RestartThreadWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = RestartThreadWidget()
}

@Composable
private fun WidgetContent(current: RecoveryThread?) {
    val size = LocalSize.current
    Column(
        modifier = GlanceModifier
            .fillMaxSize()
            .background(R.color.widget_background)
            .padding(16.dp),
        verticalAlignment = Alignment.Vertical.CenterVertically,
    ) {
        Row(verticalAlignment = Alignment.Vertical.CenterVertically) {
            Image(
                provider = ImageProvider(R.drawable.ic_restart_thread_compact),
                contentDescription = "Restart Thread",
                modifier = GlanceModifier.size(32.dp),
            )
            Text(
                "Restart Thread",
                style = TextStyle(
                    color = widgetInk,
                    fontWeight = FontWeight.Bold,
                ),
            )
        }
        Spacer(GlanceModifier.height(10.dp))
        if (current == null) {
            Text(
                "No active thread",
                style = TextStyle(color = widgetInk, fontWeight = FontWeight.Bold),
            )
            Spacer(GlanceModifier.height(8.dp))
            Button(
                text = "Leave one",
                onClick = activityAction("capture"),
                modifier = GlanceModifier.fillMaxWidth(),
            )
        } else {
            Text(
                current.proposedAction,
                maxLines = if (size.height >= 160.dp) 3 else 2,
                style = TextStyle(color = widgetInk, fontWeight = FontWeight.Bold),
            )
            if (size.height >= 160.dp) {
                Spacer(GlanceModifier.height(6.dp))
                Text(
                    current.capturedText,
                    maxLines = 2,
                    style = TextStyle(color = widgetGray),
                )
            }
            Spacer(GlanceModifier.height(8.dp))
            Row(horizontalAlignment = Alignment.Horizontal.CenterHorizontally) {
                Button(
                    text = "Return",
                    onClick = activityAction("thread", current.id),
                )
                if (size.width >= 240.dp) {
                    Button(
                        text = "Update",
                        onClick = activityAction("update", current.id),
                    )
                }
            }
        }
    }
}

private val routeKey = ActionParameters.Key<String>(RestartThreadWidget.EXTRA_ROUTE)
private val threadKey = ActionParameters.Key<String>(RestartThreadWidget.EXTRA_THREAD_ID)
private val widgetInk = ColorProvider(Color(0xFF111111))
private val widgetGray = ColorProvider(Color(0xFF545454))

private fun activityAction(route: String, threadId: String = "") =
    actionStartActivity<MainActivity>(
        actionParametersOf(routeKey to route, threadKey to threadId),
    )
