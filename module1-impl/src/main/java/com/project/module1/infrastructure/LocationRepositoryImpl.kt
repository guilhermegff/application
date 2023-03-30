package com.project.module1.infrastructure

import com.project.module1.core.Location
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val locationService: LocationService,
) : LocationRepository {
    override suspend fun getLocationList(): List<Location> {
        return locationService.locations()
    }
}