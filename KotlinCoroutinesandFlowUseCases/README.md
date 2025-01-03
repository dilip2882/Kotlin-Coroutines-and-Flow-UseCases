![CoroutineUsecasesOnAndroid](documentation/images/Logo-new.png)

# Kotlin Coroutines and Flow - Use Cases on Android

🎓 Learning Kotlin Coroutines and Flows for Android Development by Example

🚀 Sample implementations for real-world Android use cases 

🛠 Unit tests included!

This repository is intended to be a "Playground Project". You can quickly look up and play around with the different Coroutine and Flow Android implementations.
In the `playground` package you can play around with Coroutines and Flow examples that run directly on the JVM.

## 🔧 Project Setup

Every use case is using its own `Activity` and `JetPack ViewModel`. The `ViewModel`s contain most of the interesting Coroutine-related code.
`Activities` listen to `LiveData` or `StateFlow` events of the `ViewModel` and render received `UiState`s.

This project is using retrofit/okhttp together with a `MockNetworkInterceptor`. This lets you define how the API should behave.
Everything can be configured: http status codes, response data and delays. Every use case defines a certain behaviour of the Mock API.
The API has 2 endpoints. One returns the names of the most recent Android versions and the other one returns the features of a certain
Android version.

Unit Tests exist for most use cases.

## what is coroutine and flow?
### Coroutines

Coroutines are a powerful feature in Kotlin that allow you to write asynchronous, non-blocking code in a more structured and readable way. Here are the key points about coroutines:

* **Asynchronous Execution:** Coroutines provide a way to perform tasks asynchronously without blocking the main thread. They are lightweight and can handle concurrency more efficiently than traditional threads.
* **Suspend Functions:** Coroutines use `suspend` functions, which can be paused and resumed. When a `suspend` function is called, it doesn't block the thread; instead, it suspends execution until the result is available.
* **Structured Concurrency:** Coroutines are organized into structured concurrency. You can launch coroutines within specific scopes (e.g., `runBlocking`, `viewModelScope`, etc.), and they automatically manage their lifecycle.
* **Coroutine Builders:** You create coroutines using coroutine builders like `launch`, `async`, and `flow`. These builders allow you to define asynchronous tasks and handle their execution.
* **Cancellation and Exception Handling:** Coroutines provide mechanisms for graceful cancellation and exception handling.

**Example of launching a coroutine:**

```kotlin
// Launch a coroutine
GlobalScope.launch {
    val result = fetchDataFromNetwork()
    println("Received data: $result")
}
```

### Flows

Flows are a type of asynchronous stream of data in Kotlin. They are built on top of coroutines and allow you to emit multiple values sequentially. Key points about flows:

* **Multiple Values:** Unlike suspend functions that return a single value, flows can emit multiple values over time.
* **Conceptual Stream:** Think of a flow as a stream of data that can be computed asynchronously. Each emitted value must be of the same type.
* **Producer-Consumer Model:** Flows involve three entities:
    * **Producer:** Produces data that is added to the stream. For example, a repository fetching data from a network can act as a producer.
    * **Intermediaries** (optional): Modify values emitted into the stream or the stream itself.
    * **Consumer:** Consumes values from the stream (e.g., UI layer displaying data).

**Example of creating a flow manually:**

```kotlin
// Creating a flow
fun fetchNews(): Flow<List<Article>> = flow {
    while (true) {
        val latestNews = fetchLatestNewsFromApi()
        emit(latestNews) // Emit the result to the flow
        delay(5000) // Simulate periodic updates
    }
}
```

## 🍿️ Related Videos
* Kotlin Flow on Android Basics Playlist [[link](https://youtube.com/playlist?list=PL-1MzrWZIYU3McdBOEic_1nsy8Rw48xIO)]
* Kotlin Coroutines Fundamentals Playlist [[link](https://www.youtube.com/playlist?list=PL-1MzrWZIYU2a4TGbSXeXzfet8Br3cya1)]
* Kotlin Coroutines Exception Handling explained [[link](https://youtu.be/Pgek3_3vPU8)]
* How to avoid 5 common mistakes when using Kotlin Coroutines [[link](https://youtu.be/coq9XDMB-yU)]
* Best Practices for using Kotlin Coroutines in Android Development [[link](https://youtu.be/tVDCpjqQ1Ro)]

## ⭐️ Coroutine Use Cases
1. [Perform single network request](#1-perform-single-network-request)
2. [Perform two sequential network requests](#2-perform-two-sequential-network-requests)
3. [Perform several network requests concurrently](#3-perform-several-network-requests-concurrently)
4. [Perform variable amount of network requests](#4-perform-variable-amount-of-network-requests)
5. [Perform a network request with timeout](#5-perform-network-request-with-timeout)
6. [Retrying network requests](#6-retrying-network-requests)
7. [Network requests with timeout and retry](#7-network-requests-with-timeout-and-retry)
8. [Room and Coroutines](#8-room-and-coroutines)
9. [Debugging Coroutines](#9-debugging-coroutines)
10. [Offload expensive calculation to background thread](#10-offload-expensive-calculation-to-background-thread)
11. [Cooperative Cancellation](#11-cooperative-cancellation)
12. [Offload expensive calculation to several Coroutines](#12-offload-expensive-calculation-to-several-coroutines)
13. [Exception Handling](#13-exception-handling)
14. [Continue Coroutine execution even when the user leaves the screen](#14-continue-coroutine-execution-when-the-user-leaves-the-screen)
15. [Using WorkManager with Coroutines](#15-using-workmanager-with-coroutines)
16. [Performance analysis of dispatchers, number of coroutines and yielding](#16-performance-analysis-of-dispatchers-number-of-coroutines-and-yielding)
17. [Perform expensive calculation on Main Thread without freezing the UI](#17-perform-expensive-calculation-on-main-thread-without-freezing-the-ui)

## ⭐ Flow Use Cases
1. [Flow Basics](#1-flow-basics)
2. [Basic Flow intermediate operators](#2-basic-flow-intermediate-operators)
3. [Flow Exception Handling](#3-flow-exception-handling)
4. [Exposing Flows in the ViewModel](#4-exposing-flows-in-the-viewmodel)

## 📄 Coroutine Use Cases Description

### 1. Perform single network request

This use case performs a single network request to get the latest Android Versions and displays them on the screen.

[[code](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/coroutines/usecase1/PerformSingleNetworkRequestViewModel.kt)]

### 2. Perform two sequential network requests

This use case performs two network requests sequentially. First, it retrieves recent Android Versions and then it requests the features of the latest version.

There are also 2 alternative implementations included. One is using old-school [callbacks](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/coroutines/usecase2/callbacks/SequentialNetworkRequestsCallbacksViewModel.kt).
The other one uses [RxJava](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/coroutines/usecase2/rx/SequentialNetworkRequestsRxViewModel.kt). You can compare each implementation.
If you compare all three implementations, it is really interesting to see, in my opinion, how simple the Coroutine-based version actually is.

[[code](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/coroutines/usecase2/Perform2SequentialNetworkRequestsViewModel.kt)]

### 3. Perform several network requests concurrently

Performs three network requests concurrently. It loads the feature information of the 3 most recent Android Versions. Additionally, an implementation
that performs the requests sequentially is included. The UI shows how much time each implementation takes to load the data so you can see that the network
requests in the concurrent version are indeed performed in parallel. The included unit test is also interesting, as it shows how you can use virtual time to
verify that the concurrent version gets performed in parallel.

[[code](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/coroutines/usecase3/PerformNetworkRequestsConcurrentlyViewModel.kt)]

### 4. Perform variable amount of network requests

Demonstrates the simple usage of `map()` to perform a dynamic amount of network requests. At first, this use case performs a network request to load all Android versions.
Then it performs a network request for each Android version to load its features. It contains an implementation that performs the network requests sequentially and another one that performs them concurrently.

[[code](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/coroutines/usecase4/VariableAmountOfNetworkRequestsViewModel.kt)]

### 5. Perform network request with timeout

This use case uses the suspending function `withTimeout()` from the coroutines-core library. It throws a `TimeoutCancellationException` if the timeout was exceeded.
You can set the duration of the request in the UI and check the behaviour when the response time is bigger than the timeout.

General networking timeouts can also be [configured in the okhttp client](https://square.github.io/okhttp/recipes/#timeouts-kt-java).

[[code](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/coroutines/usecase5/NetworkRequestWithTimeoutViewModel.kt)]

### 6. Retrying network requests

Demonstrates the usage of higher-order functions together with coroutines. The higher-order function `retry()` retries a certain suspending operation for a given amount of times.
It uses an exponential backoff for retries, which means that the delay between retries increases exponentially. The behavior of the Mock API is defined in a way that it responses
with 2 unsuccessful responses followed by a successful response.

[[code](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/coroutines/usecase6/RetryNetworkRequestViewModel.kt)]

Unit tests verify the amount of requests that are performed in different scenarios. Furthermore, they check if the exponential backoff is working properly
by asserting the amount of elapsed virtual time.

### 7. Network requests with timeout and retry

Composes higher level functions `retry()` and `withTimeout()`. Demonstrates how simple and readable code written with Coroutines can be.
The mock API first responds after the timeout and then returns an unsuccessful response. The third attempt is then successful.

Take a look at the included [callback-based implementation](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/coroutines/usecase7/callbacks/TimeoutAndRetryCallbackViewModel.kt) to see how tricky this use case is to implement without Coroutines.

I also implemented the use case with [RxJava](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/coroutines/usecase7/rx/TimeoutAndRetryRxViewModel.kt).

[[code](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/coroutines/usecase7/TimeoutAndRetryViewModel.kt)]

### 8. Room and Coroutines

This example stores the response data of each network request in a Room database. This is essential for any "offline-first" app.
If the `View` requests data, the `ViewModel` first checks if there is data available in the database. If so, this data is returned before performing
a network request to get fresh data.

[[code](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/coroutines/usecase8/RoomAndCoroutinesViewModel.kt)]

### 9. Debugging Coroutines

This is not really a use case, but I wanted to show how you can add additional debug information about the Coroutine that is currently running to your logs.
It will add the Coroutine name next to the thread name when calling `Thread.currentThread.name()`
This is done by enabling Coroutine Debug mode by setting the property `kotlinx.coroutines.debug` to `true`.

[[code](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/coroutines/usecase9/DebuggingCoroutinesViewModel.kt)]

### 10. Offload expensive calculation to background thread

This use case calculates the factorial of a number. The calculation is performed on a background thread using the default Dispatcher.

**Attention: This use case does not support cancellation! UseCase#11 fixes this!**

[[code](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/coroutines/usecase10/CalculationInBackgroundViewModel.kt)]

In the respective unit test, we have to pass the testDispatcher to the ViewModel, so that the calculation is not performed on a background thread but on the main thread.

### 11. Cooperative cancellation

UseCase#10 has a problem. It is not able to prematurely cancel the calculation because it is not cooperative regarding cancellation. This leads to wasted device resources and
memory leaks, as the calculation is not stopped and the ViewModel is retained longer than necessary. This use case now fixes this issue. The UI now also has a "Cancel Calculation"
Button. Note: Only the calculation can be canceled prematurely but not the `toString()` conversion.

There are several ways to make your coroutines cooperative regarding cancellation: You can use either use `isActive()`, `ensureActive()` or `yield()`.
More information about cancellation can be found [here](https://medium.com/androiddevelopers/exceptions-in-coroutines-ce8da1ec060c)

[[code](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/coroutines/usecase11/CooperativeCancellationViewModel.kt)]

### 12. Offload expensive calculation to several Coroutines

The factorial calculation here is not performed by a single coroutine, but by a number of coroutines that can be defined in the UI. Each coroutine calculates the factorial of a sub-range.

[[code viewmodel](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/coroutines/usecase12/CalculationInSeveralCoroutinesViewModel.kt)]
[[code factorial calculator](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/coroutines/usecase12/FactorialCalculator.kt)]

### 13. Exception Handling

This use case demonstrates different ways of handling exceptions using `try/catch` and `CoroutineExceptionHandler`. It also demonstrates when you should use `supervisorScope{}`: In situations when you don't want a failing coroutine to cancel
its sibling coroutines. In one implementation of this use case, the results of the successful responses are shown even though one response wasn't successful.

[[code](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/coroutines/usecase13/ExceptionHandlingViewModel.kt)]

### 14. Continue Coroutine execution when the user leaves the screen

Usually, when the user leaves the screen, the `ViewModel` gets cleared and all the coroutines launched in `viewModelScope` get canceled. Sometimes, however, we want a certain coroutine operation to be continued
when the user leaves the screen. In this use case, the network request keeps running and the results still get inserted into the database
cache when the user leaves the screen. This makes sense in real-world applications as we don't want to cancel an already started background "cache sync".


You can test this behavior in the UI by clearing the database, then loading the Android version and instantly closing the screen. You will see in LogCat that the response
still gets executed and the result still gets stored. The respective unit test `AndroidVersionRepositoryTest` also verifies this behavior. Check out this [blogpost](https://medium.com/androiddevelopers/coroutines-patterns-for-work-that-shouldnt-be-cancelled-e26c40f142ad) for details of the implementation.

[[code viewmodel](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/coroutines/usecase14/ContinueCoroutineWhenUserLeavesScreenViewModel.kt)]
[[code repository](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/coroutines/usecase14/AndroidVersionRepository.kt)]

### 15. Using WorkManager with Coroutines

Demonstrates how you can use WorkManager together with Coroutines. When creating a subclass of `CoroutineWorker` instead of `Worker`,
the `doWork()` function is now a `suspend function` which means that we can now call other suspend functions. In this
example, we are sending an analytics request when the user enters the screen, which is a nice use case for using WorkManager.

[[code viewmodel](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/coroutines/usecase15/WorkManagerViewModel.kt)]
[[code worker](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/coroutines/usecase15/AnalyticsWorker.kt)]


### 16. Performance analysis of dispatchers, number of coroutines and yielding

This is an extension of use case #12 (Offload expensive calculation to several coroutines). Here it is possible to additionally define the dispatcher type you want
the calculation to be performed on. Additionally, you can enable or disable the call to `yield()` during the calculation. A list of calculations is displayed on the bottom in order to be able to compare them in a convenient way.

### 17. Perform expensive calculation on Main Thread without freezing the UI

This example shows how you can perform an expensive calculation on the main thread in a non-blocking fashion. It uses `yield()` for every step in the calculation so that other work, like drawing the UI, can be performed
on the main thread. It is more a "showcase" rather than a use case for a real application, because of performance reasons you should always perform expensive calculations on a background thread (See UseCase#10).
See [[this blog post](https://www.lukaslechner.com/how-to-run-an-expensive-calculation-with-kotlin-coroutines-on-the-android-main-thread-without-freezing-the-ui/)] for more information!


You can play around and check the performance of different configurations!

## 📄 Flow Use Cases Description

### 1. Flow Basics

This simple use case shows how to consume values from a `DataSource` that emits live stock information and how to display them in the UI. 

The datasource exposes a `Flow` which is built with the `flow{}` flow builder. It fetches fresh stock information every 5 seconds from a mocked endpoint. 

A `LiveData` property that exposes the `UiState` in the `ViewModel` is created by using the `.asLiveData()` terminal operator.
This use case also shows how to use the `map` intermediate operator and the `onStart` lifecycle operator. 

[[code viewmodel](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/flow/usecase1/FlowUseCase1ViewModel.kt)]
[[code datasource](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/flow/usecase1/StockPriceDataSource.kt)]

### 2. Basic Flow Intermediate Operators

The second use case is an extension of the first one. 
It uses some basic intermediate operators, like `withIndex`, `map`, `take` and `filter`.

[[code viewmodel](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/flow/usecase2/FlowUseCase2ViewModel.kt)]
[[code datasource](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/flow/usecase2/StockPriceDataSource.kt)]

### 3. Flow Exception Handling

The third use case shows how to properly implement exception handling with flows. 

It uses the `catch` operator to handle exceptions of our flow in the `ViewModel` and uses the `retry ` operator to retry failed network requests in the `DataSource`.

[[code viewmodel](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/flow/usecase3/FlowUseCase3ViewModel.kt)]
[[code datasource](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/flow/usecase3/StockPriceDataSource.kt)]

### 4. Exposing Flows in the ViewModel

This use case shows how to expose flows (a `StateFlow` to be precise) in the `ViewModel` instead of a `LiveData` property. 
The `statIn` operator is used to convert the ordinary, cold `Flow` into a hot `StateFlow`.

In the `Activity`, the `repeadOnLifecycle` suspend function is used to collect emissions of the `StateFlow` in a lifecycle-aware manner. 

[[code viewmodel](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/flow/usecase4/FlowUseCase4ViewModel.kt)]
[[code datasource](app/src/main/java/com/dilip/kotlincoroutinesandflowusecases/usecases/flow/usecase4/StockPriceDataSource.kt)]

