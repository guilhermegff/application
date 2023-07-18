package com.project.application.core.usecase

import com.project.application.core.model.toDataModel
import com.project.application.infrastructure.UserRepository
import com.project.application.presentation.mapper.UserUiMapper
import kotlinx.coroutines.*
import javax.inject.Inject

class GetUser @Inject constructor(
    private val userRepository: UserRepository,
    private val userUiMapper: UserUiMapper,
) {
    suspend operator fun invoke(id: String) = withContext(Dispatchers.Default) {
        println("UseCase ${Thread.currentThread().name}")
        val user = (userRepository.getUser(id))
        try {
            userRepository.saveUser(user.toDataModel())
            val fromDatabase = userRepository.fetchUser(1)
            println("/////////////")
            println("From User database: $fromDatabase")
            println("/////////////")
            userRepository.saveToken("token")
            userRepository.saveId("id")
            delay(1000)
            launch { userRepository.getId() }
            println("?????????")
        } catch (e: Exception) {
            println("From database error: $e")
        }
        userUiMapper.transform(user)
    }
}