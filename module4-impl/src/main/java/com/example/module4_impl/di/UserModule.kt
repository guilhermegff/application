package com.example.module4_impl.di

import com.example.module4_impl.core.UserDomainMapper
import com.example.module4_impl.core.model.UserDomainModel
import com.example.module4_impl.infrastructure.UserRepository
import com.example.module4_impl.infrastructure.UserRepositoryImpl
import com.example.module4_impl.presentation.UserUiMapper
import com.example.module4_impl.presentation.UserUiMapperImpl
import com.example.module4_impl.presentation.UserUiModel
import dagger.Binds
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
    fun provideUserUiMapper(): UserUiMapper<UserUiModel> = UserUiMapperImpl()
}

@Module
@InstallIn(SingletonComponent::class)
abstract class AbstractModule() {
    @Binds
    abstract fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository<UserDomainModel>
}