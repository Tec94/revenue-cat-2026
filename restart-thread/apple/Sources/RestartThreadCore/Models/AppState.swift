import Foundation

public enum AppRoute: String, Codable, Sendable {
    case bootstrap
    case welcome
    case exampleReview
    case capture
    case review
    case started
    case accountOffer
    case now
    case allThreads
    case threadDetail
    case recentlyDeleted
    case settings
    case dataPrivacy
}

public enum SwitchCurrentChoice: Sendable {
    case complete
    case archive
}

public enum CaptureProgress: String, Codable, Sendable {
    case idle
    case saving
    case saved
    case transcribing
    case drafting
    case partialSuccess
    case voiceOnly
    case failed
}

public struct MainUIState: Equatable, Sendable {
    public var route: AppRoute
    public var onboardingComplete: Bool
    public var input: String
    public var threadID: String?
    public var evidence: String
    public var action: String
    public var message: String?
    public var isRecording: Bool
    public var isExample: Bool
    public var isAIGenerated: Bool
    public var captureProgress: CaptureProgress
    public var threads: [RecoveryThread]
    public var currentThread: RecoveryThread?
    public var selectedThread: RecoveryThread?
    public var searchQuery: String
    public var showSwitchCurrent: Bool

    public init(
        route: AppRoute = .bootstrap,
        onboardingComplete: Bool = false,
        input: String = "",
        threadID: String? = nil,
        evidence: String = "",
        action: String = "",
        message: String? = nil,
        isRecording: Bool = false,
        isExample: Bool = false,
        isAIGenerated: Bool = false,
        captureProgress: CaptureProgress = .idle,
        threads: [RecoveryThread] = [],
        currentThread: RecoveryThread? = nil,
        selectedThread: RecoveryThread? = nil,
        searchQuery: String = "",
        showSwitchCurrent: Bool = false
    ) {
        self.route = route
        self.onboardingComplete = onboardingComplete
        self.input = input
        self.threadID = threadID
        self.evidence = evidence
        self.action = action
        self.message = message
        self.isRecording = isRecording
        self.isExample = isExample
        self.isAIGenerated = isAIGenerated
        self.captureProgress = captureProgress
        self.threads = threads
        self.currentThread = currentThread
        self.selectedThread = selectedThread
        self.searchQuery = searchQuery
        self.showSwitchCurrent = showSwitchCurrent
    }
}

public struct CaptureSnapshot: Codable, Equatable, Sendable {
    public let route: AppRoute
    public let input: String
    public let threadID: String?
    public let evidence: String
    public let action: String
    public let isAIGenerated: Bool

    public init(
        route: AppRoute,
        input: String,
        threadID: String?,
        evidence: String,
        action: String,
        isAIGenerated: Bool
    ) {
        self.route = route
        self.input = input
        self.threadID = threadID
        self.evidence = evidence
        self.action = action
        self.isAIGenerated = isAIGenerated
    }
}

public struct AuthUIState: Equatable, Sendable {
    public var isConfigured: Bool
    public var isAuthenticated: Bool
    public var userID: String?
    public var displayName: String?
    public var isLoading: Bool
    public var message: String?

    public init(
        isConfigured: Bool = false,
        isAuthenticated: Bool = false,
        userID: String? = nil,
        displayName: String? = nil,
        isLoading: Bool = false,
        message: String? = nil
    ) {
        self.isConfigured = isConfigured
        self.isAuthenticated = isAuthenticated
        self.userID = userID
        self.displayName = displayName
        self.isLoading = isLoading
        self.message = message
    }
}

public enum MicrophonePermissionState: Sendable {
    case granted
    case notGranted
}

public struct SubscriptionUIState: Equatable, Sendable {
    public var isConfigured: Bool
    public var isLoading: Bool
    public var isPro: Bool
    public var canPresentPaywall: Bool
    public var statusMessage: String?

    public init(
        isConfigured: Bool = false,
        isLoading: Bool = false,
        isPro: Bool = false,
        canPresentPaywall: Bool = false,
        statusMessage: String? = nil
    ) {
        self.isConfigured = isConfigured
        self.isLoading = isLoading
        self.isPro = isPro
        self.canPresentPaywall = canPresentPaywall
        self.statusMessage = statusMessage
    }
}
