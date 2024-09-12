package com.dilip.kotlincoroutinesandflowusecases.usecases.coroutines.usecase6

import com.dilip.kotlincoroutinesandflowusecases.mock.AndroidVersion

sealed class UiState {
    object Loading : UiState()
    data class Success(val recentVersions: List<AndroidVersion>) : UiState()
    data class Error(val message: String) : UiState()
}