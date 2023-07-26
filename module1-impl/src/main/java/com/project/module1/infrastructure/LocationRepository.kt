package com.project.module1.infrastructure

import com.example.datasource_api.location.LocationEntity
import com.project.module1.core.Location

interface LocationRepository {
    suspend fun getLocationList(): List<Location>
    suspend fun fetchLocation(id: Int) : LocationEntity
    suspend fun saveLocation(locationEntity: LocationEntity)
}