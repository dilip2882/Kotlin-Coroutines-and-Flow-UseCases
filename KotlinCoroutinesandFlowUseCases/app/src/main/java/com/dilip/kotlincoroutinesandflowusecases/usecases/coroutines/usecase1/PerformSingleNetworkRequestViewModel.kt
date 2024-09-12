package com.dilip.kotlincoroutinesandflowusecases.usecases.coroutines.usecase1

import com.dilip.kotlincoroutinesandflowusecases.base.BaseViewModel
import com.dilip.kotlincoroutinesandflowusecases.mock.MockApi

class PerformSingleNetworkRequestViewModel(
    private val mockApi: MockApi = mockApi()
) : BaseViewModel<UiState>() {

    fun performSingleNetworkRequest() {

    }
}