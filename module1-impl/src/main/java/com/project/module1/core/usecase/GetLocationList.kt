package com.project.module1.core.usecase

import com.project.module1.infrastructure.LocationRepository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetLocationList @Inject constructor(
    private val locationRepository: LocationRepository,
) {
    suspend operator fun invoke() = withContext(Dispatchers.Main) {
        locationRepository.getLocationList()
    }
}