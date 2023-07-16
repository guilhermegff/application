package com.example.localdatasource_impl

import android.content.Context
import com.example.localdatasource_api.location.LocationDatabaseContractFactory
import com.example.localdatasource_api.location.LocationDbMapper
import com.example.localdatasource_api.location.LocationEntity
import com.example.localdatasource_api.user.*
import com.example.localdatasource_impl.location.LocationDbMapperImpl
import com.example.localdatasource_impl.user.UserDbMapperImpl
import com.example.localdatasource_impl.user.UserLocalDao
import com.example.localdatasource_impl.user.UserSharedPreferences
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainModule {
    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context) = AppDatabase.newInstance(context)
}

@Module
@InstallIn(SingletonComponent::class)
class UserDataBaseModule {
    @Provides
    fun provideUserDao(db: AppDatabase): UserDaoContract<UserEntity> = db.provideUserDao()

    @Provides
    fun provideUserDbMapper(): UserDbMapper<UserEntity> = UserDbMapperImpl.newInstance()

    @Provides
    fun provideUserSharedPreferences(): UserSharedPreferencesDaoContract = UserSharedPreferences()
}

@Module
@InstallIn(SingletonComponent::class)
abstract class UserDataBaseAbstractModule {
    @Binds
    abstract fun provideUserLocalDao(userLocalDao: UserLocalDao): UserLocalDaoContract

    @Binds
    abstract fun provideUserDataBaseApi(db: AppDatabase): UserDataBaseContractFactory

    @Binds
    abstract fun provideLocationDataBaseApi(db: AppDatabase): LocationDatabaseContractFactory
}

@Module
@InstallIn(SingletonComponent::class)
class LocationDataBaseModule {
    @Provides
    fun provideLocationDao(db: AppDatabase) = db.provideLocationDao()

    @Provides
    fun provideLocationDbMapper(): LocationDbMapper<LocationEntity> =
        LocationDbMapperImpl.newInstance()
}