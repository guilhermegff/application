package com.project.application.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.Executor

suspend operator fun <T> Executor.invoke(function: suspend () -> T) =
    withContext(Dispatchers.Default) {
    function.invoke()
}