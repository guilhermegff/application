package com.project.module1.core.usecase

import com.project.module1.core.Location
import com.project.module1.core.toDataModel
import com.project.module1.infrastructure.LocationRepository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetLocationList @Inject constructor(
    private val locationRepository: LocationRepository,
) {
    suspend operator fun invoke() = withContext(Dispatchers.Default) {
        try {
            locationRepository.saveLocation(Location(name = "LocationName").toDataModel())
            val fromDatabase = locationRepository.fetchLocation(1)
            println("/////////////")
            println("From Location database: $fromDatabase")
            println("/////////////")
        } catch (e: Exception) {
            println("From database error: $e")
        }
        locationRepository.getLocationList()
    }
}