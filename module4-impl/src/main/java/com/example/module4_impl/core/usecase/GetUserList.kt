package com.example.module4_impl.core.usecase

import com.example.module4_impl.infrastructure.UserRepositoryImpl
import com.example.module4_impl.presentation.UserUiMapper
import com.example.module4_impl.presentation.UserUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetUserList @Inject constructor(
    private val userRepository: UserRepositoryImpl,
    private val userUiMapperImpl: UserUiMapper<UserUiModel>,
) {
    suspend operator fun invoke() = withContext(Dispatchers.Main) {
        println("UseCase ${Thread.currentThread().name}")
        userUiMapperImpl.transform((userRepository.getUserList()))
    }
}