package com.restartthread.app

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.restartthread.app.platform.AndroidRestartThreadPlatform
import com.restartthread.shared.presentation.RestartThreadController

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val controller = RestartThreadController(AndroidRestartThreadPlatform(application))
    val state = controller.state

    override fun onCleared() {
        controller.close()
    }
}
