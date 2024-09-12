package com.dilip.kotlincoroutinesandflowusecases.usecases.flow.usecase1

import androidx.lifecycle.LiveData
import com.dilip.kotlincoroutinesandflowusecases.base.BaseViewModel

class FlowUseCase1ViewModel(
    stockPriceDataSource: StockPriceDataSource
) : BaseViewModel<UiState>() {

    val currentStockPriceAsLiveData: LiveData<UiState> = TODO()

}