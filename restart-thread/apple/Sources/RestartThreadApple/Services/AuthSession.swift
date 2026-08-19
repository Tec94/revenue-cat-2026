@preconcurrency import Auth0
import Combine
import Foundation
import RestartThreadCore

public enum AuthRestoreResult: Sendable {
    case authenticated
    case signedOut
    case unavailable
}

@MainActor
public final class AuthSession: ObservableObject {
    @Published public private(set) var state: AuthUIState

    private let configuration: AppConfiguration
    private let credentialsManager: CredentialsManager?

    public init(configuration: AppConfiguration) {
        self.configuration = configuration
        if configuration.isAuth0Configured {
            credentialsManager = CredentialsManager(
                authentication: Auth0.authentication(
                    clientId: configuration.auth0ClientID,
                    domain: configuration.auth0Domain
                )
            )
        } else {
            credentialsManager = nil
        }
        state = AuthUIState(isConfigured: configuration.isAuth0Configured)
    }

    public func restoreSession() async -> AuthRestoreResult {
        guard let credentialsManager else { return .signedOut }
        guard credentialsManager.hasValid() || credentialsManager.canRenew() else {
            try? credentialsManager.clear()
            return .signedOut
        }
        do {
            _ = try await credentialsManager.credentials()
            try publishStoredProfile()
            return state.isAuthenticated ? .authenticated : .signedOut
        } catch {
            try? credentialsManager.clear()
            state = AuthUIState(
                isConfigured: true,
                message: "Your secure session couldn't be restored. Try again or sign in when you're ready."
            )
            return .unavailable
        }
    }

    public func login() async {
        guard !state.isLoading else { return }
        guard let credentialsManager else {
            state.message = "Add the Auth0 public configuration to Secrets.xcconfig first."
            return
        }
        state.isLoading = true
        state.message = nil
        do {
            _ = try await Auth0
                .webAuth(
                    clientId: configuration.auth0ClientID,
                    domain: configuration.auth0Domain
                )
                .audience(configuration.auth0Audience)
                .scope("openid profile email offline_access account:read account:delete recovery:create")
                .useCredentialsManager(credentialsManager)
                .useHTTPS()
                .start()
            try publishStoredProfile()
        } catch {
            state.isLoading = false
            state.message = "Sign-in couldn't be completed. Local use is still available."
        }
    }

    public func logout() async {
        guard !state.isLoading else { return }
        guard let credentialsManager else { return clearLocalSession() }
        state.isLoading = true
        state.message = nil
        do {
            try await Auth0
                .webAuth(
                    clientId: configuration.auth0ClientID,
                    domain: configuration.auth0Domain
                )
                .useCredentialsManager(credentialsManager)
                .useHTTPS()
                .logout()
            clearLocalSession()
        } catch {
            state.isLoading = false
            state.message = "The browser session couldn't be cleared. Try sign-out again."
        }
    }

    public func deleteCloudAccount() async {
        guard !state.isLoading else { return }
        guard let credentialsManager, let baseURL = configuration.backendBaseURL else {
            state.message = "Cloud account deletion needs Auth0 and the backend URL to be configured."
            return
        }
        state.isLoading = true
        state.message = nil
        do {
            let credentials = try await credentialsManager.credentials()
            var request = URLRequest(url: baseURL.appendingPathComponent("v1/account"))
            request.httpMethod = "DELETE"
            request.setValue("Bearer \(credentials.accessToken)", forHTTPHeaderField: "Authorization")
            let (_, response) = try await URLSession.shared.data(for: request)
            guard let http = response as? HTTPURLResponse, (200...299).contains(http.statusCode) else {
                throw AccountDeletionError.rejected
            }
            try credentialsManager.clear()
            clearLocalSession()
        } catch {
            state.isLoading = false
            state.message = "The cloud account couldn't be deleted. Local threads were not changed."
        }
    }

    private func publishStoredProfile() throws {
        guard let profile = try credentialsManager?.userProfile(), !profile.sub.isEmpty else {
            try? credentialsManager?.clear()
            state = AuthUIState(
                isConfigured: configuration.isAuth0Configured,
                message: "The sign-in callback did not contain a stable account identity."
            )
            return
        }
        state = AuthUIState(
            isConfigured: true,
            isAuthenticated: true,
            userID: profile.sub,
            displayName: profile.name ?? profile.email
        )
    }

    private func clearLocalSession() {
        try? credentialsManager?.clear()
        state = AuthUIState(isConfigured: configuration.isAuth0Configured)
    }

    private enum AccountDeletionError: Error {
        case rejected
    }
}
