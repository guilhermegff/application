package com.example.datasource_api.location

interface LocationDatabaseFactory {
    fun provideLocationDao(): LocationDao<LocationEntity>
}