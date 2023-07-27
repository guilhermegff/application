package com.example.datasource_impl.user

import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {

    @GET("users/{id}")
    suspend fun user(@Path("id") id: String): UserResponseModel

    @GET("users")
    suspend fun users(): List<UserResponseModel>
}