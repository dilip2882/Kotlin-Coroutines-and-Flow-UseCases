package com.dilip.kotlincoroutinesandflowusecases.usecases.coroutines.usecase8

import com.google.gson.Gson
import com.dilip.kotlincoroutinesandflowusecases.mock.createMockApi
import com.dilip.kotlincoroutinesandflowusecases.mock.mockAndroidVersions
import com.dilip.kotlincoroutinesandflowusecases.utils.MockNetworkInterceptor

fun mockApi() =
    createMockApi(
        MockNetworkInterceptor()
            .mock(
                "http://localhost/recent-android-versions",
                { Gson().toJson(mockAndroidVersions) },
                200,
                5000
            )
    )