package com.dilip.kotlincoroutinesandflowusecases.usecases.coroutines.usecase1

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.dilip.kotlincoroutinesandflowusecases.base.BaseActivity
import com.dilip.kotlincoroutinesandflowusecases.base.useCase1Description
import com.dilip.kotlincoroutinesandflowusecases.databinding.ActivityPerformsinglenetworkrequestBinding
import com.dilip.kotlincoroutinesandflowusecases.utils.fromHtml
import com.dilip.kotlincoroutinesandflowusecases.utils.setGone
import com.dilip.kotlincoroutinesandflowusecases.utils.setVisible
import com.dilip.kotlincoroutinesandflowusecases.utils.toast

class PerformSingleNetworkRequestActivity : BaseActivity() {

    override fun getToolbarTitle() = useCase1Description

    private val binding by lazy { ActivityPerformsinglenetworkrequestBinding.inflate(layoutInflater) }
    private val viewModel: PerformSingleNetworkRequestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.uiState().observe(this, Observer { uiState ->
            if (uiState != null) {
                render(uiState)
            }
        })
        binding.btnPerformSingleNetworkRequest.setOnClickListener {
            viewModel.performSingleNetworkRequest()
        }
    }

    private fun render(uiState: UiState) {
        when (uiState) {
            is UiState.Loading -> {
                onLoad()
            }
            is UiState.Success -> {
                onSuccess(uiState)
            }
            is UiState.Error -> {
                onError(uiState)
            }
        }
    }

    private fun onLoad() = with(binding) {
        progressBar.setVisible()
        textViewResult.text = ""
        btnPerformSingleNetworkRequest.isEnabled = false
    }

    private fun onSuccess(uiState: UiState.Success) = with(binding) {
        progressBar.setGone()
        btnPerformSingleNetworkRequest.isEnabled = true
        val readableVersions = uiState.recentVersions.map { "API ${it.apiLevel}: ${it.name}" }
        textViewResult.text = fromHtml(
            "<b>Recent Android Versions</b><br>${readableVersions.joinToString(separator = "<br>")}"
        )
    }

    private fun onError(uiState: UiState.Error) = with(binding) {
        progressBar.setGone()
        btnPerformSingleNetworkRequest.isEnabled = true
        toast(uiState.message)
    }
}