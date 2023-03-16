package com.project.module1.core.usecase

import com.project.module1.infrastructure.LocationRepository

import com.example.shared.invoke
import java.util.concurrent.Executor
import javax.inject.Inject

class GetLocationList @Inject constructor(
    private val executor: Executor,
    private val locationRepository: LocationRepository,
) {
    suspend operator fun invoke() = executor {
        locationRepository.getLocationList()
    }
}