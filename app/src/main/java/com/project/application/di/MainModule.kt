package com.project.application.di

import android.content.Context
import com.example.factory.NavigatorFactory
import com.example.localdatasource_api.UserDataBaseApi
import com.example.localdatasource_api.UserDbMapper
import com.example.localdatasource_api.UserEntity
import com.example.localdatasource_impl.AppDatabase
import com.example.localdatasource_impl.UserDbMapperImpl
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

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context) = AppDatabase.newInstance(context)

    @Singleton
    @Provides
    fun provideUserDataBaseApi(db: AppDatabase) : UserDataBaseApi = db

    //@Singleton
    @Provides
    fun provideUserDao(db: AppDatabase) = db.provideUserDao()

    @Provides
    fun provideApiClient(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }

    @Provides
    fun provideNavFactory() = NavigatorFactory()

    @Provides
    fun provideUserDbMapper() : UserDbMapper<UserEntity> = UserDbMapperImpl.newInstance()
}