package com.example.module4_impl.infrastructure

import com.example.datasource_api.user.UserEntity
import com.example.module4_impl.core.model.User

interface UserRepository {
    suspend fun fetchUser(id: String): User
    suspend fun getUserList(): List<User>
    suspend fun saveUser(userEntity: UserEntity)
    suspend fun queryUser(id: Int): UserEntity
    suspend fun saveToken(token: String)
    suspend fun saveId(id: String)
    suspend fun getId()
}