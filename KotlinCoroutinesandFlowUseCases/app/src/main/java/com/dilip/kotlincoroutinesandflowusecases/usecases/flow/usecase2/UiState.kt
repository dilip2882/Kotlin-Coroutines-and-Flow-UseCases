package com.dilip.kotlincoroutinesandflowusecases.usecases.flow.usecase2

import com.dilip.kotlincoroutinesandflowusecases.usecases.flow.mock.Stock

sealed class UiState {
    object Loading : UiState()
    data class Success(val stockList: List<Stock>) : UiState()
    data class Error(val message: String) : UiState()
}