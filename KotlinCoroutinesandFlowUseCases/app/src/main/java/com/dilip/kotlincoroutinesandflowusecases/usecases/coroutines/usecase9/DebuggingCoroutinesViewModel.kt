package com.dilip.kotlincoroutinesandflowusecases.usecases.coroutines.usecase9

import com.dilip.kotlincoroutinesandflowusecases.base.BaseViewModel
import com.dilip.kotlincoroutinesandflowusecases.mock.MockApi

class DebuggingCoroutinesViewModel(
    private val api: MockApi = mockApi()
) : BaseViewModel<UiState>() {

    fun performSingleNetworkRequest() {

    }
}