package com.project.module1.di

import com.project.module1.infrastructure.LocationRepository
import com.project.module1.infrastructure.LocationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DiModule() {

    @Binds
    abstract fun provideLocationRepo(locationRepositoryImpl: LocationRepositoryImpl): LocationRepository
}