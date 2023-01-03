package com.project.application.infrastructure

import com.project.application.core.UserDetail
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainService: MainService,
): MainRepository {
    override suspend fun getUserDetail(id: String): UserDetail {
        return mainService.user(id)
    }
}