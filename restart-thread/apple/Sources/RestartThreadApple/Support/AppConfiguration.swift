import Foundation

public struct AppConfiguration: Sendable {
    public let auth0Domain: String
    public let auth0ClientID: String
    public let auth0Audience: String
    public let backendBaseURL: URL?
    public let revenueCatAPIKey: String
    public let appGroupIdentifier: String
    public let keychainAccessGroup: String?

    public var isAuth0Configured: Bool {
        !auth0Domain.isEmpty && !auth0ClientID.isEmpty && !auth0Audience.isEmpty
    }

    public init(
        auth0Domain: String,
        auth0ClientID: String,
        auth0Audience: String,
        backendBaseURL: URL?,
        revenueCatAPIKey: String,
        appGroupIdentifier: String,
        keychainAccessGroup: String?
    ) {
        self.auth0Domain = auth0Domain
        self.auth0ClientID = auth0ClientID
        self.auth0Audience = auth0Audience
        self.backendBaseURL = backendBaseURL
        self.revenueCatAPIKey = revenueCatAPIKey
        self.appGroupIdentifier = appGroupIdentifier
        self.keychainAccessGroup = keychainAccessGroup
    }

    public static func fromBundle(_ bundle: Bundle = .main) -> AppConfiguration {
        func value(_ key: String) -> String {
            let raw = (bundle.object(forInfoDictionaryKey: key) as? String)?
                .trimmingCharacters(in: .whitespacesAndNewlines) ?? ""
            return raw.contains("$(") || raw.hasSuffix(".invalid") ? "" : raw
        }

        let backend = value("BACKEND_BASE_URL")
        return AppConfiguration(
            auth0Domain: value("AUTH0_DOMAIN"),
            auth0ClientID: value("AUTH0_CLIENT_ID"),
            auth0Audience: value("AUTH0_AUDIENCE"),
            backendBaseURL: backend.isEmpty ? nil : URL(string: backend),
            revenueCatAPIKey: value("REVENUECAT_API_KEY"),
            appGroupIdentifier: value("APP_GROUP_IDENTIFIER").isEmpty
                ? "group.com.restartthread.app"
                : value("APP_GROUP_IDENTIFIER"),
            keychainAccessGroup: value("KEYCHAIN_ACCESS_GROUP").isEmpty
                ? nil
                : value("KEYCHAIN_ACCESS_GROUP")
        )
    }
}
