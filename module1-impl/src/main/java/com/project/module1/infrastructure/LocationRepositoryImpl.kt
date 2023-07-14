package com.project.module1.infrastructure

import com.example.localdatasource_api.user.UserDaoContract
import com.example.localdatasource_api.user.UserEntity
import com.project.module1.core.Location
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val locationService: LocationService,
    private val userDao: UserDaoContract<UserEntity>,
) : LocationRepository {
    override suspend fun getLocationList(): List<Location> {
        return locationService.locations()
    }

    override suspend fun fetchUser(id: Int): UserEntity {
        return userDao.getAll().first()
    }
}