package com.project.module1

import java.util.concurrent.Executor

internal class Module1Action(
    private val executor: Executor,
    private val module1Repository: Module1Repository,
) {
    suspend operator fun invoke() = executor {
         module1Repository
    }
}

private operator fun Executor.invoke(function: () -> Unit) = function
