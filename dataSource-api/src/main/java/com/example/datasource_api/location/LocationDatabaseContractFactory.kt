package com.example.datasource_api.location

interface LocationDatabaseContractFactory {
    fun provideLocationDao(): LocationDaoContract<LocationEntity>
}