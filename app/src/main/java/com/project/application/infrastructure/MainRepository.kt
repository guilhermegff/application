package com.project.application.infrastructure

import com.project.application.core.model.UserDetail

interface MainRepository {
    suspend fun getUserDetail(id: String): UserDetail
}