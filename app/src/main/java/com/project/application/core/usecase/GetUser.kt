package com.project.application.core.usecase

import com.project.application.core.invoke
import com.project.application.infrastructure.UserRepository
import com.project.application.presentation.mapper.UserUiMapper
import java.util.concurrent.Executor
import javax.inject.Inject

class GetUser @Inject constructor(
    private val executor: Executor,
    private val userRepository: UserRepository,
    private val userUiMapper: UserUiMapper,
) {
    suspend operator fun invoke(id: String) = executor {
        println("Executor - $executor")
        println("UseCase ${Thread.currentThread().name}")
        userUiMapper.transform((userRepository.getUser(id)))
    }
}