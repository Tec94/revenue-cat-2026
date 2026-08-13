package com.restartthread.shared.presentation

data class AuthUiState(
    val isConfigured: Boolean = false,
    val isAuthenticated: Boolean = false,
    val userId: String? = null,
    val displayName: String? = null,
    val isLoading: Boolean = false,
    val message: String? = null,
)

enum class MicrophonePermissionState {
    GRANTED,
    NOT_GRANTED,
}
