import Combine
import Foundation
import RestartThreadCore

#if os(iOS)
import UIKit
#elseif os(macOS)
import AppKit
#endif

public enum SubscriptionSurface: String, Identifiable, Sendable {
    case paywall
    case customerCenter

    public var id: String { rawValue }
}

@MainActor
public final class RestartThreadAppModel: ObservableObject {
    public let controller: RestartThreadController
    public let auth: AuthSession
    public let subscriptions: SubscriptionService

    @Published public private(set) var microphonePermission: MicrophonePermissionState
    @Published public var subscriptionSurface: SubscriptionSurface?
    @Published public var showMicrophoneRationale = false

    private let platform: RestartThreadPlatform
    private let nativePlatform: AppleRestartThreadPlatform?
    private var cancellables: Set<AnyCancellable> = []
    private var hasStarted = false
    private var hasResolvedAuth = false

    public init(configuration: AppConfiguration = .fromBundle()) {
        let selectedPlatform: RestartThreadPlatform
        let applePlatform: AppleRestartThreadPlatform?
        let platformError: String?
        do {
            let created = try AppleRestartThreadPlatform(configuration: configuration)
            selectedPlatform = created
            applePlatform = created
            platformError = nil
        } catch {
            selectedPlatform = UnavailableRestartThreadPlatform()
            applePlatform = nil
            platformError = "The encrypted local vault could not be opened. No thread data will be written until this is fixed."
        }

        platform = selectedPlatform
        nativePlatform = applePlatform
        let defaults = UserDefaults(suiteName: configuration.appGroupIdentifier) ?? .standard
        controller = RestartThreadController(
            platform: selectedPlatform,
            snapshotStore: UserDefaultsCaptureSnapshotStore(defaults: defaults)
        )
        auth = AuthSession(configuration: configuration)
        subscriptions = SubscriptionService(apiKey: configuration.revenueCatAPIKey)
        microphonePermission = applePlatform?.voiceRecorder.permissionState ?? .notGranted

        if let platformError { controller.setMessage(platformError) }

        auth.$state
            .map(\.userID)
            .removeDuplicates()
            .sink { [weak self] userID in
                guard let self, self.hasResolvedAuth else { return }
                Task {
                    if let userID {
                        await self.subscriptions.identify(appUserID: userID)
                    } else {
                        await self.subscriptions.useAnonymousIdentity()
                    }
                }
            }
            .store(in: &cancellables)
    }

    public func start() async {
        guard !hasStarted else { return }
        hasStarted = true
        let authResult = await auth.restoreSession()
        hasResolvedAuth = true
        if case .authenticated = authResult, let userID = auth.state.userID {
            await subscriptions.identify(appUserID: userID)
        } else {
            await subscriptions.useAnonymousIdentity()
        }
        subscriptions.refresh()
        microphonePermission = nativePlatform?.voiceRecorder.permissionState ?? .notGranted
    }

    public func resume() {
        microphonePermission = nativePlatform?.voiceRecorder.permissionState ?? .notGranted
        subscriptions.refresh()
    }

    public func voiceTapped() {
        if controller.state.isRecording {
            controller.stopAndSaveRecording()
            return
        }
        guard let recorder = nativePlatform?.voiceRecorder else {
            controller.setMessage("Voice capture is unavailable because the local vault could not be opened.")
            return
        }
        guard recorder.permissionState == .granted else {
            showMicrophoneRationale = true
            return
        }
        microphonePermission = .granted
        controller.startRecording()
    }

    public func requestVoicePermission() async {
        showMicrophoneRationale = false
        guard let recorder = nativePlatform?.voiceRecorder else {
            controller.setMessage("Voice capture is unavailable because the local vault could not be opened.")
            return
        }
        let granted = await recorder.requestPermission()
        microphonePermission = granted ? .granted : .notGranted
        granted ? controller.startRecording() : controller.reportMicrophoneDenied()
    }

    public func continueWithText() {
        showMicrophoneRationale = false
        controller.reportMicrophoneDenied()
    }

    public func signIn() { Task { await auth.login() } }
    public func signOut() { Task { await auth.logout() } }

    public func deleteCloudAccount() { Task { await auth.deleteCloudAccount() } }
    public func restorePurchases() { subscriptions.restorePurchases() }

    public func showPaywall() {
        if subscriptions.state.canPresentPaywall {
            subscriptionSurface = .paywall
        } else {
            controller.setMessage(subscriptions.state.statusMessage ?? "Subscription options are unavailable right now.")
        }
    }

    public func showCustomerCenter() {
        #if os(iOS)
        subscriptionSurface = .customerCenter
        #else
        openExternal(Self.manageSubscriptionsURL)
        #endif
    }

    public func dismissSubscriptionSurface() {
        subscriptionSurface = nil
        subscriptions.refresh()
    }

    public func handle(url: URL) {
        guard url.scheme?.lowercased() == "restartthread" else { return }
        let components = URLComponents(url: url, resolvingAgainstBaseURL: false)
        let threadID = components?.queryItems?.first(where: { $0.name == "id" })?.value
        controller.handleDeepLink(route: url.host, threadID: threadID)
    }

    public func showWidgetInstructions() {
        #if os(iOS)
        controller.setMessage("Touch and hold the Home Screen, choose Edit, then Add Widget and select Restart Thread.")
        #else
        controller.setMessage("Open Notification Center, choose Edit Widgets, then add Restart Thread.")
        #endif
    }

    public func openSettings() {
        #if os(macOS)
        let opened = NSApp.sendAction(
            Selector(("showSettingsWindow:")),
            to: nil,
            from: nil
        )
        if !opened {
            NSApp.sendAction(Selector(("showPreferencesWindow:")), to: nil, from: nil)
        }
        #else
        controller.showSettings()
        #endif
    }

    public func openMicrophoneSettings() {
        #if os(iOS)
        guard let url = URL(string: UIApplication.openSettingsURLString) else { return }
        UIApplication.shared.open(url)
        #else
        if let url = URL(string: "x-apple.systempreferences:com.apple.preference.security?Privacy_Microphone") {
            NSWorkspace.shared.open(url)
        }
        #endif
    }

    public func openExternal(_ url: URL) {
        #if os(iOS)
        UIApplication.shared.open(url)
        #else
        NSWorkspace.shared.open(url)
        #endif
    }

    private static let manageSubscriptionsURL = URL(string: "https://apps.apple.com/account/subscriptions")!
}

@MainActor
private final class UnavailableRestartThreadPlatform: RestartThreadPlatform {
    private var onboardingComplete = false

    func hasCompletedOnboarding() -> Bool { onboardingComplete }
    func setOnboardingCompleted(_ completed: Bool) { onboardingComplete = completed }
    func newThreadID() -> String { UUID().uuidString }
    func currentTimeMillis() -> Int64 { Int64(Date().timeIntervalSince1970 * 1_000) }
    func saveThread(_ thread: RecoveryThread) -> Bool { false }
    func loadThread(id: String) -> RecoveryThread? { nil }
    func listThreads() -> [RecoveryThread] { [] }
    func permanentlyDeleteThread(id: String) -> Bool { false }
    func exportThread(_ thread: RecoveryThread) -> Bool { false }
    func startRecording() -> Bool { false }
    func stopAndSaveVoice(thread: RecoveryThread) -> Bool { false }
    func cancelRecording() {}
    func confirmHaptic() {}
}
