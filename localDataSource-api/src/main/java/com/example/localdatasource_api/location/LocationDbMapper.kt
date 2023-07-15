package com.example.localdatasource_api.location

interface LocationDbMapper<T: LocationEntity> {
    fun transform(obj: LocationEntity) : T
}