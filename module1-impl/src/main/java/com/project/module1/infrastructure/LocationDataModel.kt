package com.project.module1.infrastructure

import com.example.localdatasource_api.location.LocationEntity

data class LocationDataModel(
    override val name: String,
) : LocationEntity