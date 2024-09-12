package com.dilip.kotlincoroutinesandflowusecases.usecases.coroutines.usecase3

import com.dilip.kotlincoroutinesandflowusecases.base.BaseViewModel
import com.dilip.kotlincoroutinesandflowusecases.mock.MockApi

class PerformNetworkRequestsConcurrentlyViewModel(
    private val mockApi: MockApi = mockApi()
) : BaseViewModel<UiState>() {

    fun performNetworkRequestsSequentially() {

    }

    fun performNetworkRequestsConcurrently() {

    }
}