package com.example.module4_impl.core.usecase

import com.example.datasource_api.user.UserEntity
import com.example.module4_impl.core.model.UserDomainModel
import com.example.module4_impl.infrastructure.UserRepository
import javax.inject.Inject
import kotlin.random.Random

class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository<UserDomainModel>,
) {
    suspend operator fun invoke(id: String): GetUserUseCaseResult {
        println("UseCase ${Thread.currentThread().name}")
        val domainModel: UserDomainModel
        try {
            domainModel = userRepository.fetchUser(id)
        } catch (e: Exception) {
            return GetUserUseCaseResult.Error
        }

        saveToken(Random.nextInt(0, 100).toString())

        try {
            userRepository.saveId(domainModel.id.toString())
            userRepository.getId()
        } catch (e: Exception) {
            return GetUserUseCaseResult.SuccessWithNoId(domainModel)
        }
        return GetUserUseCaseResult.Success(domainModel)
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
    data class Success(val obj: UserEntity) : GetUserUseCaseResult
    data class SuccessWithNoId(val obj: UserEntity) : GetUserUseCaseResult
}