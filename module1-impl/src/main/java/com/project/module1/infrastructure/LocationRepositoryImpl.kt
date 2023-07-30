package com.project.module1.infrastructure

import com.example.datasource_api.location.LocationDao
import com.example.datasource_api.location.LocationDbMapper
import com.example.datasource_api.location.LocationEntity
import com.project.module1.core.Location
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val locationService: LocationService,
    private val locationDao: LocationDao<LocationEntity>,
    private val mapper: LocationDbMapper<LocationEntity>
) : LocationRepository {
    override suspend fun getLocationList(): List<Location> {
        return locationService.locations()
    }

    override suspend fun fetchLocation(id: Int): LocationEntity {
        return locationDao.getAll().first()
    }

    override suspend fun saveLocation(locationEntity: LocationEntity) {
        locationDao.insertAll(mapper.transform(locationEntity))
    }
}