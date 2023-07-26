package com.example.datasource_impl.di

import android.content.Context
import com.example.localdatasource_api.location.LocationDatabaseContractFactory
import com.example.localdatasource_api.location.LocationDbMapper
import com.example.localdatasource_api.location.LocationEntity
import com.example.localdatasource_api.user.*
import com.example.datasource_impl.AppDatabase
import com.example.datasource_impl.location.LocationDbMapperImpl
import com.example.datasource_impl.user.UserDataStore
import com.example.datasource_impl.user.UserDbMapperImpl
import com.example.datasource_impl.user.UserLocalDao
import com.example.datasource_impl.user.UserSharedPreferences
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class MainModule {
    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context) = AppDatabase.newInstance(context)
}

@Module
@InstallIn(SingletonComponent::class)
internal class UserDataBaseModule {
    @Provides
    fun provideUserDao(db: AppDatabase): UserDaoContract<UserEntity> = db.provideUserDao()

    @Provides
    fun provideUserDbMapper(): UserDbMapper<UserEntity> = UserDbMapperImpl.newInstance()

    @Singleton
    @Provides
    fun provideUserSharedPreferences(@ApplicationContext context: Context): UserSharedPreferencesDaoContract =
        UserSharedPreferences.newInstance(
            context.getSharedPreferences("User", Context.MODE_PRIVATE)
        )

    @Singleton
    @Provides
    fun provideUserDataStore(@ApplicationContext context: Context): UserDataStoreDaoContract  {
        return UserDataStore(context)
    }
}

@Module
@InstallIn(SingletonComponent::class)
internal abstract class UserDataBaseAbstractModule {
    @Binds
    abstract fun provideUserLocalDao(userLocalDao: UserLocalDao): UserLocalDaoContract

    @Binds
    abstract fun provideUserDataBaseApi(db: AppDatabase): UserDataBaseContractFactory

    @Binds
    abstract fun provideLocationDataBaseApi(db: AppDatabase): LocationDatabaseContractFactory
}

@Module
@InstallIn(SingletonComponent::class)
internal class LocationDataBaseModule {
    @Provides
    fun provideLocationDao(db: AppDatabase) = db.provideLocationDao()

    @Provides
    fun provideLocationDbMapper(): LocationDbMapper<LocationEntity> =
        LocationDbMapperImpl.newInstance()
}