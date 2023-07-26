package com.example.module4_impl.infrastructure

import com.example.module4_impl.core.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {

    @GET("users/{id}")
    suspend fun user(@Path("id") id: String): User

    @GET("users")
    suspend fun users(): List<User>
}