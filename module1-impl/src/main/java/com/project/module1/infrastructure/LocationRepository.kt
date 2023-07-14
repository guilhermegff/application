package com.project.module1.infrastructure

import com.example.localdatasource_api.user.UserEntity
import com.project.module1.core.Location

interface LocationRepository {
    suspend fun getLocationList(): List<Location>
    suspend fun fetchUser(id: Int) : UserEntity
}