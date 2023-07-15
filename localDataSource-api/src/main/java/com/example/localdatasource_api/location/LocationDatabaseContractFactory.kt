package com.example.localdatasource_api.location

interface LocationDatabaseContractFactory {
    fun provideLocationDao(): LocationDaoContract<LocationEntity>
}