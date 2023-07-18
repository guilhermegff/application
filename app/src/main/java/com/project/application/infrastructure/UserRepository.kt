package com.project.application.infrastructure

import com.example.localdatasource_api.user.UserEntity
import com.project.application.core.model.User

interface UserRepository {
    suspend fun getUser(id: String): User
    suspend fun getUserList(): List<User>
    suspend fun saveUser(userEntity: UserEntity)
    suspend fun fetchUser(id: Int): UserEntity
    suspend fun saveToken(token: String)
    suspend fun saveId(id: String)
    suspend fun getId()
}