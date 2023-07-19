package com.project.application.core.usecase

import com.project.application.core.model.toDataModel
import com.project.application.infrastructure.UserRepository
import com.project.application.presentation.mapper.UserUiMapper
import com.project.application.presentation.model.UserUiModel
import javax.inject.Inject

class GetUser @Inject constructor(
    private val userRepository: UserRepository,
    private val userUiMapper: UserUiMapper,
) {
    suspend operator fun invoke(id: String): UserUiModel {
        println("UseCase ${Thread.currentThread().name}")
        val user = (userRepository.fetchUser(id))

        try {
            userRepository.saveUser(user.toDataModel())
            val fromDatabase = userRepository.queryUser(1)
            println("/////////////")
            println("From User database: $fromDatabase")
            println("/////////////")
            userRepository.saveToken("token")
            userRepository.saveId("id")
            userRepository.getId()
            println("?????????")
        } catch (e: Exception) {
            println("From database error: $e")
        }
        return userUiMapper.transform(user)
    }
}