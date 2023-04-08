package com.project.application.core.usecase

import com.project.application.infrastructure.UserRepository
import com.project.application.presentation.mapper.UserUiMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetUser @Inject constructor(
    private val userRepository: UserRepository,
    private val userUiMapper: UserUiMapper,
) {
    suspend operator fun invoke(id: String) = withContext(Dispatchers.Default) {
        println("UseCase ${Thread.currentThread().name}")
        userUiMapper.transform((userRepository.getUser(id)))
    }
}