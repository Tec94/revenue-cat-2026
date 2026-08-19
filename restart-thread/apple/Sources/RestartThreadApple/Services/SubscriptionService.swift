@preconcurrency import RevenueCat
import Combine
import Foundation
import RestartThreadCore

@MainActor
public final class SubscriptionService: ObservableObject {
    public static let proEntitlement = "pro"

    @Published public private(set) var state = SubscriptionUIState()
    private let enabled: Bool

    public init(apiKey: String) {
        enabled = !apiKey.trimmingCharacters(in: .whitespacesAndNewlines).isEmpty
        guard enabled else { return }
        if !Purchases.isConfigured {
            Purchases.configure(withAPIKey: apiKey)
        }
        state.isConfigured = true
    }

    public func refresh() {
        guard enabled else { return }
        Task { await refreshNow() }
    }

    public func identify(appUserID: String) async {
        guard enabled, !appUserID.isEmpty else { return }
        do {
            let result = try await Purchases.shared.logIn(appUserID)
            accept(result.customerInfo)
            await refreshNow()
        } catch {
            state.statusMessage = "Pro status couldn't be linked to this account yet."
        }
    }

    public func useAnonymousIdentity() async {
        guard enabled, !Purchases.shared.isAnonymous else { return }
        do {
            accept(try await Purchases.shared.logOut())
        } catch {
            state.statusMessage = "Pro identity couldn't be cleared yet. Try again before switching accounts."
        }
    }

    public func restorePurchases() {
        guard enabled else { return }
        Task {
            do {
                accept(try await Purchases.shared.restorePurchases())
            } catch {
                state.statusMessage = "Purchases couldn't be restored right now."
            }
        }
    }

    private func refreshNow() async {
        state.isLoading = true
        state.statusMessage = nil

        do {
            accept(try await Purchases.shared.customerInfo())
        } catch {
            state.statusMessage = "Subscription status is unavailable right now."
        }

        do {
            let offerings = try await Purchases.shared.offerings()
            let current = offerings.current
            state.canPresentPaywall = current?.monthly != nil && current?.annual != nil
            if !state.canPresentPaywall {
                state.statusMessage = "Restart Thread Pro is not configured yet."
            }
        } catch {
            state.canPresentPaywall = false
            state.statusMessage = "Subscription options are unavailable right now."
        }

        state.isLoading = false
    }

    private func accept(_ customerInfo: CustomerInfo) {
        state.isPro = customerInfo.entitlements.all[Self.proEntitlement]?.isActive == true
        state.statusMessage = nil
    }

}
