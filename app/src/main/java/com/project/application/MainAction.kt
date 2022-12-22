package com.project.application

import java.util.concurrent.Executor
import javax.inject.Inject

class MainAction @Inject constructor(
    private val executor: Executor,
    private val mainRepository: MainRepository,
) : BaseAction <UserDetail>{
    override suspend operator fun invoke() = executor {
        mainRepository.getUserDetail()
    }
}

private suspend operator fun <T> Executor.invoke(function: suspend () -> T) = function.invoke()
