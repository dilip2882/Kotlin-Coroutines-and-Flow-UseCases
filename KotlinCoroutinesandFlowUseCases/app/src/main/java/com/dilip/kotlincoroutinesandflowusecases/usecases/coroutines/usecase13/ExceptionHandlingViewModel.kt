package com.dilip.kotlincoroutinesandflowusecases.usecases.coroutines.usecase13

import com.dilip.kotlincoroutinesandflowusecases.base.BaseViewModel
import com.dilip.kotlincoroutinesandflowusecases.mock.MockApi

class ExceptionHandlingViewModel(
    private val api: MockApi = mockApi()
) : BaseViewModel<UiState>() {

    fun handleExceptionWithTryCatch() {

    }

    fun handleWithCoroutineExceptionHandler() {

    }

    fun showResultsEvenIfChildCoroutineFails() {

    }
}