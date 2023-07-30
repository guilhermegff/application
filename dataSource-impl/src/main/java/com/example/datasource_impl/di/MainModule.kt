package com.example.datasource_impl.di

import android.content.Context
import com.example.datasource_api.location.LocationDatabaseFactory
import com.example.datasource_api.location.LocationDbMapper
import com.example.datasource_api.location.LocationEntity
import com.example.datasource_api.user.*
import com.example.datasource_impl.AppDatabase
import com.example.datasource_impl.location.LocationDbMapperImpl
import com.example.datasource_impl.user.*
import com.example.datasource_impl.user.UserDataStore
import com.example.datasource_impl.user.UserDbMapperImpl
import com.example.datasource_impl.user.UserSharedPreferencesDaoImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
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
class UserRemoteModule {
    @Provides
    fun provideUserService(retrofit: Retrofit): UserRemoteService {
        return retrofit.create(UserRemoteService::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class AbstractUserRemoteModule {
    @Binds
    abstract fun provideUserService(userRemoteService: UserRemoteService): UserRemoteDao
}

@Module
@InstallIn(SingletonComponent::class)
internal class UserDataBaseModule {
    @Provides
    fun provideUserDao(db: AppDatabase): UserDataBaseDao<UserEntity> = db.provideUserDao()

    @Provides
    fun provideUserDbMapper(): UserDbMapper<UserEntity> = UserDbMapperImpl.newInstance()

    @Singleton
    @Provides
    fun provideUserSharedPreferences(@ApplicationContext context: Context): UserSharedPreferencesDao =
        UserSharedPreferencesDaoImpl.newInstance(
            context.getSharedPreferences("User", Context.MODE_PRIVATE)
        )

    @Singleton
    @Provides
    fun provideUserDataStore(@ApplicationContext context: Context): UserDataStoreDao  {
        return UserDataStore(context)
    }
}

@Module
@InstallIn(SingletonComponent::class)
internal abstract class UserDataBaseAbstractModule {
    @Binds
    abstract fun provideUserLocalDao(userDao: UserDaoImpl): UserDao

    @Binds
    abstract fun provideUserDataBaseApi(db: AppDatabase): UserDataBaseFactory

    @Binds
    abstract fun provideLocationDataBaseApi(db: AppDatabase): LocationDatabaseFactory
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