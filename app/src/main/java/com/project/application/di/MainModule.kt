package com.project.application.di

import com.example.factory.IntentFactories
import com.example.localdatasource_api.user.UserEntity
import com.project.application.infrastructure.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
class LegacyFeatureInAppPackageModule {
    @Provides
    fun provideApiClient(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
class ActProv {
    @Singleton
    @Provides
    fun provideSomething() = UserDataModel1("name", "email", "gender", "status")
}

class UserDataModel1(
    override val name: String,
    override val email: String,
    override val gender: String,
    override val status: String
) : UserEntity {

}





