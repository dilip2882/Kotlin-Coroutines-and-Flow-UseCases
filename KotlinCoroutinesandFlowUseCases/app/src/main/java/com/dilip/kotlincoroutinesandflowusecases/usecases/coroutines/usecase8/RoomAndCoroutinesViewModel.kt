package com.dilip.kotlincoroutinesandflowusecases.usecases.coroutines.usecase8

import com.dilip.kotlincoroutinesandflowusecases.base.BaseViewModel
import com.dilip.kotlincoroutinesandflowusecases.mock.MockApi

class RoomAndCoroutinesViewModel(
    private val api: MockApi,
    private val database: AndroidVersionDao
) : BaseViewModel<UiState>() {

    fun loadData() {

    }

    fun clearDatabase() {

    }
}

enum class DataSource(val dataSourceName: String) {
    DATABASE("Database"),
    NETWORK("Network")
}