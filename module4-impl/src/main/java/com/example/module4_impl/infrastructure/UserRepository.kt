package com.example.module4_impl.infrastructure

import com.example.datasource_api.user.UserEntity

interface UserRepository<in IN: UserEntity, out OUT: UserEntity> {
    suspend fun fetchUser(id: String): OUT
    suspend fun getUserList(): List<OUT>
    suspend fun saveUser(userEntity: IN)
    suspend fun queryUser(id: Int): OUT
    suspend fun saveToken(token: String)
    suspend fun retrieveToken(): String
    suspend fun saveId(id: String)
    suspend fun getId()
}