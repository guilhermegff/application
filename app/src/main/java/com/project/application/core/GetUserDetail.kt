package com.project.application.core

import com.project.application.infrastructure.MainRepository
import com.project.application.presentation.UserDetailUiMapper
import java.util.concurrent.Executor
import javax.inject.Inject

class GetUserDetail @Inject constructor(
    private val executor: Executor,
    private val mainRepository: MainRepository,
    private val userDetailUiMapper: UserDetailUiMapper,
)  {
    suspend operator fun invoke(id: String) = executor {
        userDetailUiMapper.transform((mainRepository.getUserDetail(id)))
    }
}