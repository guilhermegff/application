package com.project.module1.infrastructure

import com.project.module1.core.Location
import retrofit2.http.GET

interface LocationService {
    @GET("locations")
    suspend fun locations(): List<Location>
}