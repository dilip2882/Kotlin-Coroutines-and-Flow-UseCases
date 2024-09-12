package com.dilip.kotlincoroutinesandflowusecases.usecases.coroutines.usecase6

import com.google.gson.Gson
import com.dilip.kotlincoroutinesandflowusecases.mock.createMockApi
import com.dilip.kotlincoroutinesandflowusecases.mock.mockAndroidVersions
import com.dilip.kotlincoroutinesandflowusecases.utils.MockNetworkInterceptor

fun mockApi() = createMockApi(
    MockNetworkInterceptor()
        .mock(
            "http://localhost/recent-android-versions",
            { "something went wrong on server side" },
            500,
            1000,
            persist = false
        ).mock(
            "http://localhost/recent-android-versions",
            { "something went wrong on server side" },
            500,
            1000,
            persist = false
        ).mock(
            "http://localhost/recent-android-versions",
            { Gson().toJson(mockAndroidVersions) },
            200,
            1000
        )
)