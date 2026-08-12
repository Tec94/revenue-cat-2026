package com.restartthread.shared.billing

import com.revenuecat.purchases.kmp.Purchases
import com.revenuecat.purchases.kmp.PurchasesConfiguration
import com.revenuecat.purchases.kmp.PurchasesDelegate
import com.revenuecat.purchases.kmp.LogLevel
import com.revenuecat.purchases.kmp.models.CustomerInfo
import com.revenuecat.purchases.kmp.models.EntitlementVerificationMode
import com.revenuecat.purchases.kmp.models.Offering
import com.revenuecat.purchases.kmp.models.PurchasesError
import com.revenuecat.purchases.kmp.models.StoreProduct
import com.revenuecat.purchases.kmp.models.StoreTransaction
import com.revenuecat.purchases.kmp.result.awaitCustomerInfoResult
import com.revenuecat.purchases.kmp.result.awaitOfferingsResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

object RevenueCatIds {
    const val PRO_ENTITLEMENT = "pro"
}

data class SubscriptionUiState(
    val isConfigured: Boolean = false,
    val isLoading: Boolean = false,
    val isPro: Boolean = false,
    val canPresentPaywall: Boolean = false,
    val statusMessage: String? = null,
)

fun configureRevenueCat(apiKey: String, debugLogs: Boolean = false): Boolean {
    if (apiKey.isBlank()) return false
    if (Purchases.isConfigured) return true

    return runCatching {
        if (debugLogs) Purchases.logLevel = LogLevel.DEBUG
        Purchases.configure(
            PurchasesConfiguration(apiKey) {
                verificationMode = EntitlementVerificationMode.INFORMATIONAL
            },
        )
    }.isSuccess
}

class RevenueCatSubscriptionController(enabled: Boolean) {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
    private val purchases = if (enabled && Purchases.isConfigured) {
        Purchases.sharedInstance
    } else {
        null
    }
    private val mutableState = MutableStateFlow(
        SubscriptionUiState(isConfigured = purchases != null),
    )

    val state: StateFlow<SubscriptionUiState> = mutableState.asStateFlow()
    internal var currentOffering: Offering? = null
        private set

    private val delegate = object : PurchasesDelegate {
        override fun onPurchasePromoProduct(
            product: StoreProduct,
            startPurchase: (
                onError: (error: PurchasesError, userCancelled: Boolean) -> Unit,
                onSuccess: (
                    storeTransaction: StoreTransaction,
                    customerInfo: CustomerInfo,
                ) -> Unit,
            ) -> Unit,
        ) = Unit

        override fun onCustomerInfoUpdated(customerInfo: CustomerInfo) {
            acceptCustomerInfo(customerInfo)
        }
    }

    init {
        purchases?.delegate = delegate
        refresh()
    }

    fun refresh() {
        val configuredPurchases = purchases ?: return
        scope.launch {
            mutableState.value = mutableState.value.copy(
                isLoading = true,
                statusMessage = null,
            )

            val customerInfo = configuredPurchases.awaitCustomerInfoResult()
            val offerings = configuredPurchases.awaitOfferingsResult()

            customerInfo.onSuccess(::acceptCustomerInfo)
            currentOffering = offerings.getOrNull()?.current
            val hasLaunchPackages = currentOffering?.let {
                it.monthly != null && it.annual != null
            } == true

            mutableState.value = mutableState.value.copy(
                isLoading = false,
                canPresentPaywall = hasLaunchPackages,
                statusMessage = when {
                    customerInfo.isFailure -> "Subscription status is unavailable right now."
                    offerings.isFailure -> "Subscription options are unavailable right now."
                    !hasLaunchPackages -> "Restart Thread Pro is not configured yet."
                    else -> null
                },
            )
        }
    }

    internal fun acceptCustomerInfo(customerInfo: CustomerInfo) {
        mutableState.value = mutableState.value.copy(
            isPro = RevenueCatIds.PRO_ENTITLEMENT in customerInfo.entitlements.active,
            statusMessage = null,
        )
    }

    internal fun reportPurchaseFailure() {
        mutableState.value = mutableState.value.copy(
            statusMessage = "The purchase couldn't be completed. Try again when you're ready.",
        )
    }

    internal fun reportRestoreFailure() {
        mutableState.value = mutableState.value.copy(
            statusMessage = "Purchases couldn't be restored right now.",
        )
    }

    fun close() {
        purchases?.delegate = null
        scope.cancel()
    }
}
