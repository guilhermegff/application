package com.example.module4_impl.infrastructure

import com.example.datasource_api.user.UserEntity

interface UserRepository<T: UserEntity> {
    suspend fun fetchUser(id: String): T
    suspend fun getUserList(): List<T>
    suspend fun saveUser(userEntity: T)
    suspend fun queryUser(id: Int): T
    suspend fun saveToken(token: String)
    suspend fun retrieveToken(): String
    suspend fun saveId(id: String)
    suspend fun getId()
}