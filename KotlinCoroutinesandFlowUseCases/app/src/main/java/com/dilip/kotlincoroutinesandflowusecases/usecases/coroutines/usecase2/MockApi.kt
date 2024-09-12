package com.dilip.kotlincoroutinesandflowusecases.usecases.coroutines.usecase2

import com.google.gson.Gson
import com.dilip.kotlincoroutinesandflowusecases.mock.createMockApi
import com.dilip.kotlincoroutinesandflowusecases.mock.mockAndroidVersions
import com.dilip.kotlincoroutinesandflowusecases.mock.mockVersionFeaturesAndroid10
import com.dilip.kotlincoroutinesandflowusecases.utils.MockNetworkInterceptor

fun mockApi() = createMockApi(
    MockNetworkInterceptor()
        .mock(
            "http://localhost/recent-android-versions",
            { Gson().toJson(mockAndroidVersions) },
            200,
            1500
        )
        .mock(
            "http://localhost/android-version-features/29",
            { Gson().toJson(mockVersionFeaturesAndroid10) },
            200,
            1500
        )
)