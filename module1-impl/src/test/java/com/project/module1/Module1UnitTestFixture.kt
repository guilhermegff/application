package com.project.module1

import com.project.module1.core.Location
import com.project.module1.presentation.LocationUiModel

interface Module1UnitTestFixture {
    val locationList
        get() = listOf<Location>(
            Location("A"),
            Location("B"),
            Location("C")
        )

    val uiModelLocationList
        get() = listOf<LocationUiModel>(
            LocationUiModel("A"),
            LocationUiModel("B"),
            LocationUiModel("C")
        )
}