package com.project.application.di

import com.example.factory.NavigatorFactory
import com.example.factory_api.AbstractNavigatorFactory2
import com.example.localdatasource_api.location.LocationDatabaseContractFactory
import com.example.localdatasource_api.user.UserDataBaseContractFactory
import com.example.localdatasource_impl.AppDatabase
import com.project.application.infrastructure.UserRepository
import com.project.application.infrastructure.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DiModule() {
    @Binds
    abstract fun provideNavigationFactory(navigatorFactory: NavigatorFactory) : AbstractNavigatorFactory2
}

@Module
@InstallIn(SingletonComponent::class)
abstract class UserDiModule() {
    @Binds
    abstract fun provideUserDataBaseApi(db: AppDatabase) : UserDataBaseContractFactory

    @Binds
    abstract fun provideLocationDataBaseApi(db: AppDatabase) : LocationDatabaseContractFactory

    @Binds
    abstract fun provideRepo(userDetailRepositoryImpl: UserRepositoryImpl) : UserRepository
}