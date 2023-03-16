package com.project.module1.infrastructure

import com.project.module1.core.Location

interface LocationRepository {
    suspend fun getLocationList(): List<Location>
}