package com.example.datasource_api.user

interface UserRemoteDao {
    suspend fun user(id: String): UserEntity
    suspend fun users(): List<UserEntity>
}