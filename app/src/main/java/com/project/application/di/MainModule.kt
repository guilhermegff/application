package com.project.application.di

import android.content.Context
import com.example.factory.IntentFactories
import com.example.localdatasource_api.location.LocationDbMapper
import com.example.localdatasource_api.location.LocationEntity
import com.example.localdatasource_api.user.UserDbMapper
import com.example.localdatasource_api.user.UserEntity
import com.example.localdatasource_impl.AppDatabase
import com.example.localdatasource_impl.location.LocationDbMapperImpl
import com.example.localdatasource_impl.user.UserDbMapperImpl
import com.project.application.infrastructure.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainModule {
    @Provides
    fun provideIntentFactories() = IntentFactories()
}

@Module
@InstallIn(SingletonComponent::class)
class ApplicationHttpServiceModule {
    @Singleton
    @Provides
    fun provideOkHttp(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}

@Module
@InstallIn(SingletonComponent::class)
class ApplicationDataBaseModule {
    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context) = AppDatabase.newInstance(context)
}

@Module
@InstallIn(SingletonComponent::class)
class UserDataBaseModule {
    @Provides
    fun provideUserDao(db: AppDatabase) = db.provideUserDao()

    @Provides
    fun provideUserDbMapper() : UserDbMapper<UserEntity> = UserDbMapperImpl.newInstance()
}

@Module
@InstallIn(SingletonComponent::class)
class LocationDataBaseModule {
    @Provides
    fun provideLocationDao(db: AppDatabase) = db.provideLocationDao()

    @Provides
    fun provideLocationDbMapper() : LocationDbMapper<LocationEntity> = LocationDbMapperImpl.newInstance()
}

@Module
@InstallIn(SingletonComponent::class)
class LegacyFeatureInAppPackageModule {
    @Provides
    fun provideApiClient(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }
}