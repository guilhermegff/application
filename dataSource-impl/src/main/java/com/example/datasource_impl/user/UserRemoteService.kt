package com.example.datasource_impl.user

import com.example.datasource_api.user.UserRemoteDao
import retrofit2.http.GET
import retrofit2.http.Path

interface UserRemoteService : UserRemoteDao {

    @GET("users/{id}")
    override suspend fun user(@Path("id") id: String): UserResponseModel

    @GET("users")
    override suspend fun users(): List<UserResponseModel>
}