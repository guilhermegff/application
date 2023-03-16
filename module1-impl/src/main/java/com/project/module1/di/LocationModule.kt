package com.project.module1.di

import com.project.module1.infrastructure.LocationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class LocationModule {

    @Provides
    fun provideApiClient(retrofit: Retrofit): LocationService {
        return retrofit.create(LocationService::class.java)
    }
}