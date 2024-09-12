package com.dilip.kotlincoroutinesandflowusecases.usecases.coroutines.usecase2.rx

import com.dilip.kotlincoroutinesandflowusecases.base.BaseViewModel

class SequentialNetworkRequestsRxViewModel(
    private val mockApi: RxMockApi = mockApi()
) : BaseViewModel<UiState>() {

    fun perform2SequentialNetworkRequest() {

    }
}