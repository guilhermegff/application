package com.project.application.di

import com.example.factory.IntentFactories
import com.example.factory_api.Module2IntentFactory
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
    abstract fun provideIntentFactory(intentFactories: IntentFactories): Module2IntentFactory
}

@Module
@InstallIn(SingletonComponent::class)
abstract class UserDiModuleForLegacyFeatureInAppPackage() {
    @Binds
    abstract fun provideRepo(userDetailRepositoryImpl: UserRepositoryImpl): UserRepository
}