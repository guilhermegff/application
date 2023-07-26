package com.example.module4_impl.di

import com.example.module4_impl.infrastructure.UserRepository
import com.example.module4_impl.infrastructure.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DiModule() {
    @Binds
    abstract fun provideRepo(userDetailRepositoryImpl: UserRepositoryImpl): UserRepository
}