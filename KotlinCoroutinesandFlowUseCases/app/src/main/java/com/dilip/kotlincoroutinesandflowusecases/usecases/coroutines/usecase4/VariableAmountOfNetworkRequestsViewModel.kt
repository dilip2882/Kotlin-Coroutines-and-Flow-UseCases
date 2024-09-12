package com.dilip.kotlincoroutinesandflowusecases.usecases.coroutines.usecase4

import com.dilip.kotlincoroutinesandflowusecases.base.BaseViewModel
import com.dilip.kotlincoroutinesandflowusecases.mock.MockApi

class VariableAmountOfNetworkRequestsViewModel(
    private val mockApi: MockApi = mockApi()
) : BaseViewModel<UiState>() {

    fun performNetworkRequestsSequentially() {

    }

    fun performNetworkRequestsConcurrently() {

    }
}