package com.example.module4_impl.core.usecase

import com.example.module4_impl.core.model.UserDomainModel
import com.example.module4_impl.infrastructure.UserRepositoryImpl
import com.example.module4_impl.presentation.UserUiMapper
import com.example.module4_impl.presentation.UserUiModel
import javax.inject.Inject
import kotlin.random.Random

class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepositoryImpl,
    private val userUiMapper: UserUiMapper,
) {
    suspend operator fun invoke(id: String): GetUserUseCaseResult {
        println("UseCase ${Thread.currentThread().name}")
        val user: UserDomainModel
        try {
            user = userRepository.fetchUser(id)
        } catch (e: Exception) {
            return GetUserUseCaseResult.Error
        }

        saveToken(Random.nextInt(0, 100).toString())

        val uiModel = userUiMapper.transform(user)
        try {
            userRepository.saveId(user.id.toString())
            userRepository.getId()
        } catch (e: Exception) {
            return GetUserUseCaseResult.SuccessWithNoId(uiModel)
        }
        return GetUserUseCaseResult.Success(uiModel)
    }

    private suspend fun saveToken(token: String) {
        try {
            userRepository.saveToken("token $token")
            println("Token was saved: $token")
        } catch (e: Exception) {
            println("Token was not saved: $token")
            println("Token exception: $e")
        }
    }
}

sealed interface GetUserUseCaseResult {
    object Error : GetUserUseCaseResult
    data class Success(val obj: UserUiModel) : GetUserUseCaseResult
    data class SuccessWithNoId(val obj: UserUiModel) : GetUserUseCaseResult
}