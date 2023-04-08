package com.project.application.di

import com.example.module1_api.Module1Navigator
import com.example.module2_api.Module2Navigator
import com.example.module2_impl.Module2NavigatorImpl
import com.project.application.infrastructure.UserRepository
import com.project.application.infrastructure.UserRepositoryImpl
import com.project.module1.Module1NavigatorImpl
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
    abstract fun provideModule1(module1NavigatorImpl: Module1NavigatorImpl) : Module1Navigator

    @Binds
    abstract fun provideModule2(module2NavigatorImpl: Module2NavigatorImpl) : Module2Navigator
}