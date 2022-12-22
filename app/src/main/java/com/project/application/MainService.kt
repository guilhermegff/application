package com.project.application

import retrofit2.http.GET

interface MainService {

    @GET("users/5690")
    suspend fun user() : UserDetail
}