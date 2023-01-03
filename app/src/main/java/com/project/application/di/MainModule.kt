package com.project.application.di

import com.project.application.core.GetUserDetail
import com.project.application.infrastructure.MainRepository
import com.project.application.infrastructure.MainService
import com.project.application.presentation.UserDetailUiMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Singleton
    @Provides
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(provideLoggingInterceptor())
            .build()
    }

    @Singleton
    @Provides
    @Named("loggingInterceptor")
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://gorest.co.in/public/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideApiClient(retrofit: Retrofit): MainService {
        return retrofit.create(MainService::class.java)
    }

    @Provides
    fun provideExecutor() =
        ExecutorImpl()

    @Provides
    fun providerUserDetailUiMapper() =
        UserDetailUiMapper()

    @Provides
    fun provideAction(
        mainRepository: MainRepository,
    ) = GetUserDetail(
        provideExecutor(),
        mainRepository,
        providerUserDetailUiMapper()
    )
}