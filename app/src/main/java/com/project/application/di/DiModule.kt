package com.project.application.di

import com.example.factory.NavigatorFactory
import com.example.factory_api.AbstractNavigatorFactory2
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
    abstract fun provideRepo(userDetailRepositoryImpl: UserRepositoryImpl) : UserRepository

    @Binds
    abstract fun provideNavigationFactory(navigatorFactory: NavigatorFactory) : AbstractNavigatorFactory2
}