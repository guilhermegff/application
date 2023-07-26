package com.project.module1.infrastructure

import com.example.datasource_api.location.LocationEntity

data class LocationDataModel(
    override val name: String,
) : LocationEntity