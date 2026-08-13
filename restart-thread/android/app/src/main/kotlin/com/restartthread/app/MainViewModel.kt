package com.restartthread.app

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.restartthread.app.platform.AndroidRestartThreadPlatform
import com.restartthread.shared.presentation.AppRoute
import com.restartthread.shared.presentation.CaptureSnapshot
import com.restartthread.shared.presentation.RestartThreadController
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainViewModel(
    application: Application,
    private val savedState: SavedStateHandle,
) : AndroidViewModel(application) {
    val controller = RestartThreadController(
        platform = AndroidRestartThreadPlatform(application),
        restoredCapture = savedState.get<String>(KEY_ROUTE)?.let { routeName ->
            runCatching { AppRoute.valueOf(routeName) }.getOrNull()?.let { route ->
                CaptureSnapshot(
                    route = route,
                    input = savedState.get<String>(KEY_INPUT).orEmpty(),
                    threadId = savedState.get<String>(KEY_THREAD_ID),
                    evidence = savedState.get<String>(KEY_EVIDENCE).orEmpty(),
                    action = savedState.get<String>(KEY_ACTION).orEmpty(),
                    isAiGenerated = savedState.get<Boolean>(KEY_AI_GENERATED) ?: false,
                )
            }
        },
    )
    val state = controller.state

    init {
        viewModelScope.launch {
            state.collectLatest { current ->
                if (current.route in setOf(AppRoute.CAPTURE, AppRoute.REVIEW) && !current.isExample) {
                    savedState[KEY_ROUTE] = current.route.name
                    savedState[KEY_INPUT] = current.input
                    savedState[KEY_THREAD_ID] = current.threadId
                    savedState[KEY_EVIDENCE] = current.evidence
                    savedState[KEY_ACTION] = current.action
                    savedState[KEY_AI_GENERATED] = current.isAiGenerated
                } else {
                    savedState.remove<String>(KEY_ROUTE)
                    savedState.remove<String>(KEY_INPUT)
                    savedState.remove<String>(KEY_THREAD_ID)
                    savedState.remove<String>(KEY_EVIDENCE)
                    savedState.remove<String>(KEY_ACTION)
                    savedState.remove<Boolean>(KEY_AI_GENERATED)
                }
            }
        }
    }

    override fun onCleared() {
        controller.close()
    }

    private companion object {
        const val KEY_ROUTE = "capture_route"
        const val KEY_INPUT = "capture_input"
        const val KEY_THREAD_ID = "capture_thread_id"
        const val KEY_EVIDENCE = "capture_evidence"
        const val KEY_ACTION = "capture_action"
        const val KEY_AI_GENERATED = "capture_ai_generated"
    }
}
