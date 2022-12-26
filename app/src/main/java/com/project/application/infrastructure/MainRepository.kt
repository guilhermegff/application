package com.project.application.infrastructure

import com.project.application.core.UserDetail

interface MainRepository {
    suspend fun getUserDetail(): UserDetail
}