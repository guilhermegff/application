package com.example.datasource_api.location

interface LocationDao<T: LocationEntity> {
    fun getAll(): List<T>
    fun loadAllByIds(locationIds: IntArray): List<T>
    fun findByName(first: String): LocationEntity
    fun insertAll(locations: T)
    fun delete(location: T)
}