package com.restartthread.app.auth

import android.app.Activity
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.authentication.storage.CredentialsManagerException
import com.auth0.android.authentication.storage.SecureCredentialsManager
import com.auth0.android.authentication.storage.SharedPreferencesStorage
import com.auth0.android.callback.Callback
import com.auth0.android.jwt.JWT
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.result.Credentials
import com.restartthread.app.BuildConfig
import com.restartthread.shared.presentation.AuthUiState
import java.net.HttpURLConnection
import java.net.URI
import java.util.concurrent.Executors
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AndroidAuthGateway(private val activity: Activity) {
    private val configured = BuildConfig.AUTH0_CLIENT_ID.isNotBlank() &&
        BuildConfig.AUTH0_DOMAIN.isNotBlank() &&
        BuildConfig.AUTH0_AUDIENCE.isNotBlank()
    private val account = if (configured) {
        Auth0.getInstance(BuildConfig.AUTH0_CLIENT_ID, BuildConfig.AUTH0_DOMAIN)
    } else {
        null
    }
    private val credentialsManager = account?.let {
        SecureCredentialsManager(
            activity.applicationContext,
            it,
            SharedPreferencesStorage(activity.applicationContext),
        )
    }
    private val executor = Executors.newSingleThreadExecutor()
    private val mutableState = MutableStateFlow(AuthUiState(isConfigured = configured))
    val state: StateFlow<AuthUiState> = mutableState.asStateFlow()

    init {
        restoreSession()
    }

    fun login() {
        val auth0 = account ?: run {
            mutableState.value = mutableState.value.copy(
                message = "Add the Auth0 public configuration to local.properties first.",
            )
            return
        }
        mutableState.value = mutableState.value.copy(isLoading = true, message = null)
        WebAuthProvider.login(auth0)
            .withScheme("https")
            .withScope(
                "openid profile email offline_access account:read account:delete recovery:create",
            )
            .withAudience(BuildConfig.AUTH0_AUDIENCE)
            .start(activity, object : Callback<Credentials, AuthenticationException> {
                override fun onSuccess(result: Credentials) {
                    credentialsManager?.saveCredentials(result)
                    publishCredentials(result)
                }

                override fun onFailure(error: AuthenticationException) {
                    mutableState.value = mutableState.value.copy(
                        isLoading = false,
                        message = when {
                            error.isAuthenticationCanceled -> "Sign-in was cancelled. Local use is still available."
                            error.isBrowserAppNotAvailable -> "No compatible browser is available for secure sign-in."
                            else -> "Sign-in couldn't be completed. Check your connection and try again."
                        },
                    )
                }
            })
    }

    fun logout() {
        val auth0 = account ?: return clearLocalSession()
        mutableState.value = mutableState.value.copy(isLoading = true, message = null)
        WebAuthProvider.logout(auth0)
            .withScheme("https")
            .start(activity, object : Callback<Void?, AuthenticationException> {
                override fun onSuccess(result: Void?) = clearLocalSession()

                override fun onFailure(error: AuthenticationException) {
                    mutableState.value = mutableState.value.copy(
                        isLoading = false,
                        message = if (error.isAuthenticationCanceled) {
                            "Sign-out was cancelled."
                        } else {
                            "The browser session couldn't be cleared. Try sign-out again."
                        },
                    )
                }
            })
    }

    fun deleteCloudAccount() {
        val manager = credentialsManager
        if (manager == null || BuildConfig.BACKEND_BASE_URL.isBlank()) {
            mutableState.value = mutableState.value.copy(
                message = "Cloud account deletion needs Auth0 and the backend URL to be configured.",
            )
            return
        }
        mutableState.value = mutableState.value.copy(isLoading = true, message = null)
        manager.getCredentials(object : Callback<Credentials, CredentialsManagerException> {
            override fun onSuccess(result: Credentials) {
                executor.execute {
                    val deleted = runCatching {
                        val endpoint = URI.create(
                            BuildConfig.BACKEND_BASE_URL.trimEnd('/') + "/v1/account",
                        ).toURL()
                        val connection = endpoint.openConnection() as HttpURLConnection
                        try {
                            connection.requestMethod = "DELETE"
                            connection.setRequestProperty("Authorization", "Bearer ${result.accessToken}")
                            connection.connectTimeout = 10_000
                            connection.readTimeout = 10_000
                            connection.responseCode in 200..299
                        } finally {
                            connection.disconnect()
                        }
                    }.getOrDefault(false)
                    activity.runOnUiThread {
                        if (deleted) {
                            clearLocalSession()
                        } else {
                            mutableState.value = mutableState.value.copy(
                                isLoading = false,
                                message = "The cloud account couldn't be deleted. Local threads were not changed.",
                            )
                        }
                    }
                }
            }

            override fun onFailure(error: CredentialsManagerException) {
                mutableState.value = mutableState.value.copy(
                    isLoading = false,
                    message = "Sign in again before deleting the cloud account.",
                )
            }
        })
    }

    fun close() {
        executor.shutdown()
    }

    private fun restoreSession() {
        val manager = credentialsManager ?: return
        if (!manager.hasValidCredentials()) return
        manager.getCredentials(object : Callback<Credentials, CredentialsManagerException> {
            override fun onSuccess(result: Credentials) = publishCredentials(result)

            override fun onFailure(error: CredentialsManagerException) {
                clearLocalSession("Your secure session expired. Sign in again when you're ready.")
            }
        })
    }

    private fun publishCredentials(credentials: Credentials) {
        val token = runCatching { JWT(credentials.idToken) }.getOrNull()
        val userId = token?.subject
        if (userId.isNullOrBlank()) {
            credentialsManager?.clearCredentials()
            mutableState.value = AuthUiState(
                isConfigured = configured,
                message = "The sign-in callback did not contain a stable account identity.",
            )
            return
        }
        val displayName = token.getClaim("name").asString()
            ?: token.getClaim("email").asString()
        mutableState.value = AuthUiState(
            isConfigured = configured,
            isAuthenticated = true,
            userId = userId,
            displayName = displayName,
        )
    }

    private fun clearLocalSession(message: String? = null) {
        credentialsManager?.clearCredentials()
        mutableState.value = AuthUiState(isConfigured = configured, message = message)
    }
}
