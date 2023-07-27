package com.example.datasource_api.user

interface UserRemoteDaoContract {
    suspend fun user(id: String): UserEntity
    suspend fun users(): List<UserEntity>
}