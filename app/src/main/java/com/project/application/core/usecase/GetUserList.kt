package com.project.application.core.usecase

import com.project.application.core.invoke
import com.project.application.infrastructure.UserRepository
import com.project.application.presentation.mapper.UserUiMapper
import java.util.concurrent.Executor
import javax.inject.Inject

class GetUserList @Inject constructor(
    private val executor: Executor,
    private val userRepository: UserRepository,
    private val userUiMapper: UserUiMapper,
)  {
    suspend operator fun invoke() = executor {
        println("UseCase ${Thread.currentThread().name}")
        userUiMapper.transform((userRepository.getUserList()))
    }
}