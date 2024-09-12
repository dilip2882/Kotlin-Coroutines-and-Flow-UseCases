package com.dilip.kotlincoroutinesandflowusecases.usecases.coroutines.usecase5

import com.dilip.kotlincoroutinesandflowusecases.base.BaseViewModel
import com.dilip.kotlincoroutinesandflowusecases.mock.MockApi

class NetworkRequestWithTimeoutViewModel(
    private val api: MockApi = mockApi()
) : BaseViewModel<UiState>() {

    fun performNetworkRequest(timeout: Long) {

    }

}