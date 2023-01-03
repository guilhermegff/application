package com.project.application.infrastructure

import com.project.application.core.model.User

interface UserRepository {
    suspend fun getUserDetail(id: String): User
    suspend fun getUserDetailList(): List<User>
}