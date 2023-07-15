package com.example.localdatasource_api.location

interface LocationDaoContract<T: LocationEntity> {
    fun getAll(): List<T>
    fun loadAllByIds(locationIds: IntArray): List<T>
    fun findByName(first: String): LocationEntity
    fun insertAll(locations: T)
    fun delete(location: T)
}