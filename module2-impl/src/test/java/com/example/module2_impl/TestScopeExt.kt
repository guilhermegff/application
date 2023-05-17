package com.example.module2_impl

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle

@OptIn(ExperimentalCoroutinesApi::class)
fun <T> TestScope.launchCollect(state: Flow<T>): List<T> {
    val results = mutableListOf<T>()
    val job = launch {
        state.collect() {
            results.add(it)
        }
    }
    advanceUntilIdle()
    job.cancel()
    for (result in results) {
        println(result)
    }
    return results
}