package com.example.module4_impl.di

import com.example.datasource_api.user.UserDaoContract
import com.example.module4_impl.core.UserDomainMapper
import com.example.module4_impl.infrastructure.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MainModule() {
    @Provides
    fun provideDomainMapper() = UserDomainMapper()

    @Provides
    fun provideRepoImpl(
        userDao: UserDaoContract, userDomainMapper: UserDomainMapper
    ) = UserRepositoryImpl(userDao, userDomainMapper)
}