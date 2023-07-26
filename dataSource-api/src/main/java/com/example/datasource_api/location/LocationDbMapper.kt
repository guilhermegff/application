package com.example.datasource_api.location

interface LocationDbMapper<T: LocationEntity> {
    fun transform(obj: LocationEntity) : T
}