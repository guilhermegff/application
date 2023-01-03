package com.project.application.infrastructure

import com.project.application.core.UserDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface MainService {

    @GET("users/{id}")
    suspend fun user(@Path("id") id: String): UserDetail
}