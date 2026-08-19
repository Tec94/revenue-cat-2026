import RestartThreadCore
import RevenueCatUI
import SwiftUI

public struct RestartThreadRootView: View {
    @Environment(\.scenePhase) private var scenePhase
    @ObservedObject private var model: RestartThreadAppModel
    @ObservedObject private var controller: RestartThreadController
    @ObservedObject private var auth: AuthSession
    @ObservedObject private var subscriptions: SubscriptionService

    public init(model: RestartThreadAppModel) {
        self.model = model
        controller = model.controller
        auth = model.auth
        subscriptions = model.subscriptions
    }

    public var body: some View {
        ScrollView {
            VStack(spacing: 0) {
                if controller.state.route != .bootstrap && controller.state.route != .welcome {
                    BrandHeader(
                        showBack: showBack,
                        showSettings: showSettings,
                        onBack: { controller.goBack() },
                        onSettings: { model.openSettings() }
                    )
                    .padding(.bottom, 28)
                }

                RouteContentView(model: model)

                if let message = controller.state.message {
                    StatusBanner(text: message).padding(.top, 20)
                }
                Spacer(minLength: 36)
            }
            .frame(maxWidth: contentWidth)
            .padding(.horizontal, horizontalPadding)
            .padding(.vertical, 12)
            .frame(maxWidth: .infinity)
        }
        .restartThreadBackground()
        .confirmationDialog(
            "Choose what happens to the current thread",
            isPresented: Binding(
                get: { controller.state.showSwitchCurrent },
                set: { if !$0 { controller.dismissCurrentSwitch() } }
            ),
            titleVisibility: .visible
        ) {
            Button("Complete and continue") { controller.resolveCurrentThread(.complete) }
            Button("Archive and continue") { controller.resolveCurrentThread(.archive) }
            Button("Cancel", role: .cancel) { controller.dismissCurrentSwitch() }
        } message: {
            Text("Only one thread can be current. \"\(controller.state.currentThread?.proposedAction ?? "Current thread")\" will not be replaced without your choice.")
        }
        .sheet(item: $model.subscriptionSurface, onDismiss: { model.dismissSubscriptionSurface() }) { surface in
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
        .task { await model.start() }
        .onOpenURL(perform: model.handle)
        .onChange(of: scenePhase) { phase in
            if phase == .active {
                model.resume()
            } else {
                controller.close()
            }
        }
    }

    private var showBack: Bool {
        controller.state.route == .dataPrivacy ||
            controller.state.onboardingComplete && ![.now, .accountOffer].contains(controller.state.route)
    }

    private var showSettings: Bool {
        controller.state.onboardingComplete && ![.settings, .dataPrivacy].contains(controller.state.route)
    }

    private var contentWidth: CGFloat {
        #if os(macOS)
        1_040
        #else
        720
        #endif
    }

    private var horizontalPadding: CGFloat {
        #if os(macOS)
        32
        #else
        20
        #endif
    }
}

private struct RouteContentView: View {
    @ObservedObject var model: RestartThreadAppModel
    @ObservedObject private var controller: RestartThreadController
    @ObservedObject private var auth: AuthSession
    @ObservedObject private var subscriptions: SubscriptionService

    init(model: RestartThreadAppModel) {
        self.model = model
        controller = model.controller
        auth = model.auth
        subscriptions = model.subscriptions
    }

    @ViewBuilder
    var body: some View {
        switch controller.state.route {
        case .bootstrap:
            BootstrapScreen()
        case .welcome:
            WelcomeScreen(controller: controller)
        case .exampleReview:
            ReviewScreen(controller: controller, isExample: true)
        case .capture:
            CaptureScreen(model: model)
        case .review:
            ReviewScreen(controller: controller, isExample: false)
        case .started:
            StartedScreen(controller: controller)
        case .accountOffer:
            AccountOfferScreen(model: model)
        case .now:
            NowScreen(controller: controller, openSettings: model.openSettings)
        case .allThreads:
            AllThreadsScreen(controller: controller)
        case .threadDetail:
            ThreadDetailScreen(controller: controller)
        case .recentlyDeleted:
            RecentlyDeletedScreen(controller: controller)
        case .settings:
            RestartThreadSettingsView(model: model, embedded: true)
        case .dataPrivacy:
            DataPrivacyScreen(controller: controller)
        }
    }
}
