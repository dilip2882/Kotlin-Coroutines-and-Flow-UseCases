package com.dilip.kotlincoroutinesandflowusecases.usecases.flow.usecase1

import android.os.Bundle
import androidx.activity.viewModels
import com.dilip.kotlincoroutinesandflowusecases.base.BaseActivity
import com.dilip.kotlincoroutinesandflowusecases.base.flowUseCase1Description
import com.dilip.kotlincoroutinesandflowusecases.databinding.ActivityFlowUsecase1Binding
import com.dilip.kotlincoroutinesandflowusecases.utils.setGone
import com.dilip.kotlincoroutinesandflowusecases.utils.setVisible
import com.dilip.kotlincoroutinesandflowusecases.utils.toast
import org.joda.time.LocalDateTime
import org.joda.time.format.DateTimeFormat

class FlowUseCase1Activity : BaseActivity() {

    private val binding by lazy { ActivityFlowUsecase1Binding.inflate(layoutInflater) }
    private val adapter = StockAdapter()

    private val viewModel: FlowUseCase1ViewModel by viewModels {
        ViewModelFactory(NetworkStockPriceDataSource(mockApi(applicationContext)))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recyclerView.adapter = adapter

        viewModel.currentStockPriceAsLiveData.observe(this) { uiState ->
            if (uiState != null) {
                render(uiState)
            }
        }
    }

    private fun render(uiState: UiState) {
        when (uiState) {
            is UiState.Loading -> {
                binding.progressBar.setVisible()
                binding.recyclerView.setGone()
            }
            is UiState.Success -> {
                binding.recyclerView.setVisible()
                binding.lastUpdateTime.text =
                    "lastUpdateTime: ${LocalDateTime.now().toString(DateTimeFormat.fullTime())}"
                adapter.stockList = uiState.stockList
                binding.progressBar.setGone()
            }
            is UiState.Error -> {
                toast(uiState.message)
                binding.progressBar.setGone()
            }
        }
    }

    override fun getToolbarTitle() = flowUseCase1Description
}