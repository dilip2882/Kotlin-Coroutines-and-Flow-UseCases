package com.dilip.kotlincoroutinesandflowusecases.usecases.flow.usecase1

import android.content.Context
import com.google.gson.Gson
import com.dilip.kotlincoroutinesandflowusecases.usecases.flow.mock.createFlowMockApi
import com.dilip.kotlincoroutinesandflowusecases.usecases.flow.mock.fakeCurrentStockPrices
import com.dilip.kotlincoroutinesandflowusecases.utils.MockNetworkInterceptor

fun mockApi(context: Context) =
    createFlowMockApi(
        MockNetworkInterceptor()
            .mock(
                path = "/current-stock-prices",
                body = { Gson().toJson(fakeCurrentStockPrices(context)) },
                status = 200,
                delayInMs = 1500,
            )
    )