package com.restartthread.shared.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.restartthread.shared.billing.RevenueCatSubscriptionController
import com.restartthread.shared.billing.SubscriptionUiState
import com.restartthread.shared.presentation.MainUiState
import com.restartthread.shared.presentation.AuthUiState
import com.restartthread.shared.presentation.MicrophonePermissionState
import com.revenuecat.purchases.kmp.models.CustomerInfo
import com.revenuecat.purchases.kmp.models.PurchasesError
import com.revenuecat.purchases.kmp.models.StoreTransaction
import com.revenuecat.purchases.kmp.ui.revenuecatui.CustomerCenter
import com.revenuecat.purchases.kmp.ui.revenuecatui.Paywall
import com.revenuecat.purchases.kmp.ui.revenuecatui.PaywallListener
import com.revenuecat.purchases.kmp.ui.revenuecatui.PaywallOptions
import kotlinx.coroutines.flow.collectLatest

private enum class SubscriptionSurface { APP, PAYWALL, CUSTOMER_CENTER }

@Composable
fun RestartThreadApp(
    state: MainUiState,
    authState: AuthUiState,
    microphonePermission: MicrophonePermissionState,
    subscriptions: RevenueCatSubscriptionController?,
    actions: RestartThreadUiActions,
) {
    var subscriptionState by remember { mutableStateOf(SubscriptionUiState()) }
    var surface by remember { mutableStateOf(SubscriptionSurface.APP) }

    LaunchedEffect(subscriptions) {
        subscriptions?.state?.collectLatest { subscriptionState = it }
    }

    when (surface) {
        SubscriptionSurface.PAYWALL -> {
            val controller = subscriptions
            if (controller == null || controller.currentOffering == null) {
                surface = SubscriptionSurface.APP
            } else {
                val listener = remember(controller) {
                    object : PaywallListener {
                        override fun onPurchaseCompleted(
                            customerInfo: CustomerInfo,
                            storeTransaction: StoreTransaction,
                        ) {
                            controller.acceptCustomerInfo(customerInfo)
                            surface = SubscriptionSurface.APP
                        }

                        override fun onPurchaseError(error: PurchasesError) {
                            controller.reportPurchaseFailure()
                        }

                        override fun onRestoreCompleted(customerInfo: CustomerInfo) {
                            controller.acceptCustomerInfo(customerInfo)
                            surface = SubscriptionSurface.APP
                        }

                        override fun onRestoreError(error: PurchasesError) {
                            controller.reportRestoreFailure()
                        }
                    }
                }
                val options = remember(controller, controller.currentOffering) {
                    PaywallOptions(dismissRequest = { surface = SubscriptionSurface.APP }) {
                        offering = controller.currentOffering
                        shouldDisplayDismissButton = true
                        this.listener = listener
                    }
                }
                Paywall(options)
            }
        }

        SubscriptionSurface.CUSTOMER_CENTER -> CustomerCenter(
            modifier = Modifier.fillMaxSize(),
            onDismiss = {
                subscriptions?.refresh()
                surface = SubscriptionSurface.APP
            },
        )

        SubscriptionSurface.APP -> RestartThreadScreen(
            state = state,
            authState = authState,
            microphonePermission = microphonePermission,
            subscriptionState = subscriptionState,
            onUpgrade = if (subscriptionState.canPresentPaywall) {
                { surface = SubscriptionSurface.PAYWALL }
            } else {
                null
            },
            onManageSubscription = if (subscriptionState.isPro) {
                { surface = SubscriptionSurface.CUSTOMER_CENTER }
            } else {
                null
            },
            actions = actions.copy(
                restorePurchases = { subscriptions?.restorePurchases() },
            ),
        )
    }
}
