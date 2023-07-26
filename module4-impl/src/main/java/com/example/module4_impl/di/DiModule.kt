package com.example.module4_impl.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UserDiModuleForLegacyFeatureInAppPackage() {
    @Binds
    abstract fun provideRepo(userDetailRepositoryImpl: com.example.module4_impl.infrastructure.UserRepositoryImpl): com.example.module4_impl.infrastructure.UserRepository
}