package com.antivirus.testapp.util

sealed interface UiState<out T> {
    data object Idle : UiState<Nothing>
    data object Loading : UiState<Nothing>

    data class Error(val error: Throwable) : UiState<Nothing>
    data class Success<out T>(val data: T) : UiState<T>
}