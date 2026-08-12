package com.restartthread.app.billing

import android.app.Application
import com.restartthread.app.BuildConfig
import com.restartthread.shared.billing.configureRevenueCat

object StoreBillingInitializer {
    fun initialize(application: Application) {
        val apiKey = if (BuildConfig.DEBUG) {
            BuildConfig.REVENUECAT_TEST_API_KEY.ifBlank { BuildConfig.REVENUECAT_API_KEY }
        } else {
            BuildConfig.REVENUECAT_API_KEY
        }
        configureRevenueCat(apiKey, debugLogs = BuildConfig.DEBUG)
    }
}
