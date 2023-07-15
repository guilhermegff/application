package com.project.module1.core

import com.project.module1.infrastructure.LocationDataModel

data class Location(
    val name: String
)

fun Location.toDataModel() = LocationDataModel(
    name = this.name
)