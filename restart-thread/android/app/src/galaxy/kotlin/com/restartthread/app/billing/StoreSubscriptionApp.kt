package com.restartthread.app.billing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.restartthread.shared.billing.RevenueCatIds
import com.restartthread.shared.billing.SubscriptionUiState
import com.restartthread.shared.presentation.MainUiState
import com.restartthread.shared.presentation.AuthUiState
import com.restartthread.shared.presentation.MicrophonePermissionState
import com.restartthread.shared.ui.RestartThreadScreen
import com.restartthread.shared.ui.RestartThreadUiActions
import com.revenuecat.purchases.CustomerInfo
import com.revenuecat.purchases.Offering
import com.revenuecat.purchases.Purchases
import com.revenuecat.purchases.PurchasesError
import com.revenuecat.purchases.getCustomerInfoWith
import com.revenuecat.purchases.getOfferingsWith
import com.revenuecat.purchases.logInWith
import com.revenuecat.purchases.logOutWith
import com.revenuecat.purchases.interfaces.ReceiveCustomerInfoCallback
import com.revenuecat.purchases.models.StoreTransaction
import com.revenuecat.purchases.ui.revenuecatui.Paywall
import com.revenuecat.purchases.ui.revenuecatui.PaywallListener
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions
import com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenter

private enum class GalaxySubscriptionSurface { APP, PAYWALL, CUSTOMER_CENTER }

@Composable
fun StoreSubscriptionApp(
    state: MainUiState,
    authState: AuthUiState,
    microphonePermission: MicrophonePermissionState,
    actions: RestartThreadUiActions,
) {
    val isConfigured = Purchases.isConfigured
    var customerInfoFailed by remember { mutableStateOf(false) }
    var offering by remember { mutableStateOf<Offering?>(null) }
    var surface by remember { mutableStateOf(GalaxySubscriptionSurface.APP) }
    var subscriptionState by remember(isConfigured) {
        mutableStateOf(
            SubscriptionUiState(
                isConfigured = isConfigured,
                isLoading = isConfigured,
            ),
        )
    }

    fun acceptCustomerInfo(customerInfo: CustomerInfo) {
        subscriptionState = subscriptionState.copy(
            isPro = customerInfo.entitlements.active.containsKey(
                RevenueCatIds.PRO_ENTITLEMENT,
            ),
            statusMessage = null,
        )
        customerInfoFailed = false
    }

    fun refresh() {
        if (!isConfigured) return
        subscriptionState = subscriptionState.copy(
            isLoading = true,
            statusMessage = null,
        )
        customerInfoFailed = false
        offering = null
        Purchases.sharedInstance.getCustomerInfoWith(
            onError = {
                customerInfoFailed = true
                subscriptionState = subscriptionState.copy(
                    isLoading = false,
                    statusMessage = "Subscription status is unavailable right now.",
                )
            },
            onSuccess = ::acceptCustomerInfo,
        )
        Purchases.sharedInstance.getOfferingsWith(
            onError = {
                subscriptionState = subscriptionState.copy(
                    isLoading = false,
                    canPresentPaywall = false,
                    statusMessage = "Subscription options are unavailable right now.",
                )
            },
            onSuccess = { offerings ->
                offering = offerings.current
                val hasLaunchPackages = offering?.let {
                    it.monthly != null && it.annual != null
                } == true
                subscriptionState = subscriptionState.copy(
                    isLoading = false,
                    canPresentPaywall = hasLaunchPackages,
                    statusMessage = when {
                        customerInfoFailed -> {
                            "Subscription status is unavailable right now."
                        }
                        !hasLaunchPackages -> {
                            "Restart Thread Pro is not configured yet."
                        }
                        else -> null
                    },
                )
            },
        )
    }

    LaunchedEffect(isConfigured) {
        refresh()
    }
    LaunchedEffect(authState.userId, isConfigured) {
        if (!isConfigured) return@LaunchedEffect
        val userId = authState.userId
        if (userId != null) {
            Purchases.sharedInstance.logInWith(
                appUserID = userId,
                onError = {
                    subscriptionState = subscriptionState.copy(
                        statusMessage = "Pro status couldn't be linked to this account yet.",
                    )
                },
                onSuccess = { customerInfo, _ -> acceptCustomerInfo(customerInfo) },
            )
        } else if (!Purchases.sharedInstance.isAnonymous) {
            Purchases.sharedInstance.logOutWith(
                onError = {
                    subscriptionState = subscriptionState.copy(
                        statusMessage = "Pro identity couldn't be cleared yet.",
                    )
                },
                onSuccess = ::acceptCustomerInfo,
            )
        }
    }

    when (surface) {
        GalaxySubscriptionSurface.PAYWALL -> {
            val paywallListener = remember {
                object : PaywallListener {
                    override fun onPurchaseCompleted(
                        customerInfo: CustomerInfo,
                        storeTransaction: StoreTransaction,
                    ) {
                        acceptCustomerInfo(customerInfo)
                        surface = GalaxySubscriptionSurface.APP
                    }

                    override fun onPurchaseError(error: PurchasesError) {
                        subscriptionState = subscriptionState.copy(
                            statusMessage =
                                "The purchase couldn't be completed. Try again when you're ready.",
                        )
                    }

                    override fun onRestoreCompleted(customerInfo: CustomerInfo) {
                        acceptCustomerInfo(customerInfo)
                        surface = GalaxySubscriptionSurface.APP
                    }

                    override fun onRestoreError(error: PurchasesError) {
                        subscriptionState = subscriptionState.copy(
                            statusMessage = "Purchases couldn't be restored right now.",
                        )
                    }
                }
            }
            val options = remember(offering) {
                PaywallOptions.Builder {
                    surface = GalaxySubscriptionSurface.APP
                }
                    .setOffering(offering)
                    .setShouldDisplayDismissButton(true)
                    .setListener(paywallListener)
                    .build()
            }
            Paywall(options)
        }

        GalaxySubscriptionSurface.CUSTOMER_CENTER -> CustomerCenter(
            onDismiss = {
                refresh()
                surface = GalaxySubscriptionSurface.APP
            },
        )

        GalaxySubscriptionSurface.APP -> RestartThreadScreen(
            state = state,
            authState = authState,
            microphonePermission = microphonePermission,
            subscriptionState = subscriptionState,
            onUpgrade = if (subscriptionState.canPresentPaywall) {
                { surface = GalaxySubscriptionSurface.PAYWALL }
            } else {
                null
            },
            onManageSubscription = if (subscriptionState.isPro) {
                { surface = GalaxySubscriptionSurface.CUSTOMER_CENTER }
            } else {
                null
            },
            actions = actions.copy(
                restorePurchases = {
                    if (isConfigured) {
                        Purchases.sharedInstance.restorePurchases(
                            object : ReceiveCustomerInfoCallback {
                                override fun onError(error: PurchasesError) {
                                subscriptionState = subscriptionState.copy(
                                    statusMessage = "Purchases couldn't be restored right now.",
                                )
                                }

                                override fun onReceived(customerInfo: CustomerInfo) {
                                    acceptCustomerInfo(customerInfo)
                                }
                            },
                        )
                    }
                },
            ),
        )
    }
}
