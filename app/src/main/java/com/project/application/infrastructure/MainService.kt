package com.project.application.infrastructure

import com.project.application.core.UserDetail
import retrofit2.http.GET

interface MainService {

    @GET("users/5690")
    suspend fun user() : UserDetail
}