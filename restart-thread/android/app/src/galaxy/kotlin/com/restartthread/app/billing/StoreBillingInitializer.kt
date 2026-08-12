package com.restartthread.app.billing

import android.app.Application
import com.restartthread.app.BuildConfig
import com.revenuecat.purchases.LogLevel
import com.revenuecat.purchases.Purchases
import com.revenuecat.purchases.galaxy.GalaxyConfiguration
import com.revenuecat.purchases.galaxy.GalaxyBillingMode

object StoreBillingInitializer {
    fun initialize(application: Application) {
        if (BuildConfig.REVENUECAT_API_KEY.isBlank()) return
        val billingMode = if (BuildConfig.DEBUG) {
            GalaxyBillingMode.TEST
        } else {
            GalaxyBillingMode.PRODUCTION
        }
        if (BuildConfig.DEBUG) Purchases.logLevel = LogLevel.DEBUG
        Purchases.configure(
            GalaxyConfiguration.Builder(
                application,
                BuildConfig.REVENUECAT_API_KEY,
                billingMode,
            ).build(),
        )
    }
}
