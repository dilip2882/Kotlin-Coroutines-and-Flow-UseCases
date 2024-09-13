package com.dilip.kotlincoroutinesandflowusecases.playground.fundamentals

import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() {
//    repeat(1_000_000) {
//        thread {
//            Thread.sleep(5000)
//            print(".")
//        }
//    }
    doCS()
}

fun doCS() {
    repeat(100000) {
        runBlocking {
            println("/")
        }
    }
}
