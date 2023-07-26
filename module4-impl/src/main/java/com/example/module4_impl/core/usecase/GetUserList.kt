package com.example.module4_impl.core.usecase

import com.example.module4_impl.infrastructure.UserRepository
import com.example.module4_impl.presentation.UserUiMapper
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