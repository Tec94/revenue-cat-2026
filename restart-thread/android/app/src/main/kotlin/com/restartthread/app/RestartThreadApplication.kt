package com.restartthread.app

import android.app.Application
import com.restartthread.app.billing.StoreBillingInitializer

class RestartThreadApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        StoreBillingInitializer.initialize(this)
    }
}

