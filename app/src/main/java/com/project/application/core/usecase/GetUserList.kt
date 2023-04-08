package com.project.application.core.usecase

import com.project.application.infrastructure.UserRepository
import com.project.application.presentation.mapper.UserUiMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetUserList @Inject constructor(
    private val userRepository: UserRepository,
    private val userUiMapper: UserUiMapper,
) {
    suspend operator fun invoke() = withContext(Dispatchers.Main) {
        println("UseCase ${Thread.currentThread().name}")
        userUiMapper.transform((userRepository.getUserList()))
    }
}