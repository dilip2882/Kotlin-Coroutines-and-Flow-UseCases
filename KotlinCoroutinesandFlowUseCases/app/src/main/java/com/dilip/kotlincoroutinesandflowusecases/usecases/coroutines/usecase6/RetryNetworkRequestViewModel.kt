package com.dilip.kotlincoroutinesandflowusecases.usecases.coroutines.usecase6

import com.dilip.kotlincoroutinesandflowusecases.base.BaseViewModel
import com.dilip.kotlincoroutinesandflowusecases.mock.MockApi

class RetryNetworkRequestViewModel(
    private val api: MockApi = mockApi()
) : BaseViewModel<UiState>() {

    fun performNetworkRequest() {

    }

}