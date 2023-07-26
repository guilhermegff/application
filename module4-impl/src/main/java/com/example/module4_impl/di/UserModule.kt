package com.example.module4_impl.di

import com.example.module4_impl.infrastructure.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class UserModule {
    @Provides
    fun provideApiClient(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }
}