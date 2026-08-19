import RestartThreadCore
import RevenueCatUI
import SwiftUI

public struct RestartThreadSettingsView: View {
    @Environment(\.dismiss) private var dismiss
    @ObservedObject private var model: RestartThreadAppModel
    @ObservedObject private var controller: RestartThreadController
    @ObservedObject private var auth: AuthSession
    @ObservedObject private var subscriptions: SubscriptionService
    private let embedded: Bool

    @State private var confirmLocalDelete = false
    @State private var confirmCloudDelete = false
    @State private var localSubscriptionSurface: SubscriptionSurface?

    public init(model: RestartThreadAppModel, embedded: Bool = false) {
        self.model = model
        controller = model.controller
        auth = model.auth
        subscriptions = model.subscriptions
        self.embedded = embedded
    }

    public var body: some View {
        Group {
            if embedded {
                settingsContent
            } else {
                ScrollView {
                    settingsContent
                        .frame(maxWidth: 720)
                        .padding(24)
                }
                .restartThreadBackground()
                #if os(macOS)
                .frame(minWidth: 620, minHeight: 620)
                #endif
            }
        }
        .alert("Move all threads to Recently deleted?", isPresented: $confirmLocalDelete) {
            Button("Move all threads", role: .destructive) { controller.deleteAllLocalThreads() }
            Button("Cancel", role: .cancel) {}
        } message: {
            Text("You can restore them later or delete them permanently.")
        }
        .alert("Delete cloud account?", isPresented: $confirmCloudDelete) {
            Button("Delete cloud account", role: .destructive) { model.deleteCloudAccount() }
            Button("Cancel", role: .cancel) {}
        } message: {
            Text("This removes Auth0 and cloud allowance data. Local threads stay on this device.")
        }
        .sheet(
            item: Binding(
                get: { embedded ? nil : localSubscriptionSurface },
                set: { if !embedded { localSubscriptionSurface = $0 } }
            ),
            onDismiss: { subscriptions.refresh() }
        ) { surface in
            switch surface {
            case .paywall:
                PaywallView()
            case .customerCenter:
                #if os(iOS)
                CustomerCenterView()
                #else
                EmptyView()
                #endif
            }
        }
    }

    private var settingsContent: some View {
        VStack(alignment: .leading, spacing: 24) {
            PageIntro(
                eyebrow: "Preferences and access",
                title: "Settings",
                bodyText: "Manage your account, Pro access, local data, and Apple surfaces."
            )
            if !embedded, let message = controller.state.message {
                StatusBanner(text: message)
            }
            SettingsCard(
                title: "Account",
                summary: accountSummary,
                badge: auth.state.isAuthenticated ? "Connected" : "Optional"
            ) {
                if !auth.state.isConfigured {
                    Text("Auth0 is not configured. You can continue to use local threads.")
                        .foregroundStyle(.secondary)
                }
                if auth.state.isAuthenticated {
                    SettingsActionRow(
                        title: "Sign out",
                        supporting: "Keep local threads on this device.",
                        action: { model.signOut() }
                    )
                    SettingsActionRow(
                        title: "Delete cloud account",
                        supporting: "Remove account access and cloud allowance data.",
                        destructive: true
                    ) { confirmCloudDelete = true }
                } else {
                    SettingsActionRow(
                        title: "Create or sign in",
                        supporting: "Link Pro and cloud allowance to your account.",
                        action: { model.signIn() }
                    )
                }
                if let message = auth.state.message { Text(message).foregroundStyle(.secondary) }
            }

            SettingsCard(
                title: "Restart Thread Pro",
                summary: subscriptions.state.isPro ? "Pro is active" : "Free plan",
                badge: subscriptions.state.isPro ? "Active" : nil
            ) {
                if subscriptions.state.isPro {
                    SettingsActionRow(
                        title: "Manage subscription",
                        supporting: subscriptionManagementDescription,
                        action: { showCustomerCenter() }
                    )
                } else if subscriptions.state.canPresentPaywall {
                    SettingsActionRow(
                        title: "Explore Pro",
                        supporting: "Compare the available monthly and yearly plans.",
                        action: { showPaywall() }
                    )
                }
                SettingsActionRow(
                    title: "Restore purchases",
                    supporting: "Check this App Store account for active purchases.",
                    action: { model.restorePurchases() }
                )
                if let message = subscriptions.state.statusMessage {
                    Text(message).foregroundStyle(.secondary)
                }
            }

            SettingsCard(
                title: "Voice and AI",
                summary: "Thread text and audio stay encrypted on this device.",
                badge: model.microphonePermission == .granted ? "Microphone on" : "Microphone off"
            ) {
                SettingsActionRow(
                    title: "Microphone permission",
                    supporting: model.microphonePermission == .granted
                        ? "Voice capture is available."
                        : "Text capture remains fully available.",
                    action: { model.openMicrophoneSettings() }
                )
            }

            SettingsCard(
                title: "Data",
                summary: "Local threads and cloud account data are separate."
            ) {
                SettingsActionRow(
                    title: "Privacy and local data",
                    supporting: "See what stays local and what an account links.",
                    action: showDataPrivacy
                )
                Text("Export is available from each thread.").foregroundStyle(.secondary)
                SettingsActionRow(
                    title: "Delete all local threads",
                    supporting: "Move every local thread to Recently deleted.",
                    destructive: true
                ) { confirmLocalDelete = true }
            }

            SettingsCard(
                title: "Home widget",
                summary: "Return to the current thread from the Home Screen or Notification Center.",
                badge: "Apple"
            ) {
                SettingsActionRow(
                    title: "Add home widget",
                    supporting: "The widget can show your current first step. Add it only where that is private enough.",
                    action: { model.showWidgetInstructions() }
                )
            }

            SettingsCard(title: "About") {
                SettingsActionRow(title: "Privacy policy") { model.openExternal(Self.privacyURL) }
                SettingsActionRow(title: "Terms") { model.openExternal(Self.termsURL) }
                SettingsActionRow(title: "Support") { model.openExternal(Self.supportURL) }
            }
        }
    }

    private var accountSummary: String {
        if auth.state.isAuthenticated { return auth.state.displayName ?? "Signed in" }
        return auth.state.isConfigured ? "Using Restart Thread without an account" : "Local-only use"
    }

    private var subscriptionManagementDescription: String {
        #if os(iOS)
        "Open Customer Center for billing and cancellation options."
        #else
        "Open Apple subscription settings for billing and cancellation options."
        #endif
    }

    private func showDataPrivacy() {
        controller.showDataPrivacy()
        if !embedded { dismiss() }
    }

    private func showPaywall() {
        if embedded {
            model.showPaywall()
        } else if subscriptions.state.canPresentPaywall {
            localSubscriptionSurface = .paywall
        } else {
            controller.setMessage(
                subscriptions.state.statusMessage ?? "Subscription options are unavailable right now."
            )
        }
    }

    private func showCustomerCenter() {
        #if os(macOS)
        model.showCustomerCenter()
        #else
        if embedded {
            model.showCustomerCenter()
        } else {
            localSubscriptionSurface = .customerCenter
        }
        #endif
    }

    private static let privacyURL = URL(string: "https://restartthread.app/privacy")!
    private static let termsURL = URL(string: "https://restartthread.app/terms")!
    private static let supportURL = URL(string: "https://restartthread.app/support")!
}
