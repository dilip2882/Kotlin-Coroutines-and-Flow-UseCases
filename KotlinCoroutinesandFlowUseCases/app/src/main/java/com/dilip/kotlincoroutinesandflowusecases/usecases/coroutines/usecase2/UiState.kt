package com.dilip.kotlincoroutinesandflowusecases.usecases.coroutines.usecase2

import com.dilip.kotlincoroutinesandflowusecases.mock.VersionFeatures

sealed class UiState {
    object Loading : UiState()
    data class Success(
        val versionFeatures: VersionFeatures
    ) : UiState()

    data class Error(val message: String) : UiState()
}