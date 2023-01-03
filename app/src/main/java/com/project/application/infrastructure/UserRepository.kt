package com.project.application.infrastructure

import com.project.application.core.model.User

interface UserRepository {
    suspend fun getUser(id: String): User
    suspend fun getUserList(): List<User>
}