package com.project.application.di

import com.example.module1_api.Module1Navigator
import com.project.application.infrastructure.UserRepository
import com.project.application.infrastructure.UserRepositoryImpl
import com.project.module1.Module1NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.Executor

@Module
@InstallIn(SingletonComponent::class)
abstract class DiModule() {

    @Binds
    abstract fun provideRepo(userDetailRepositoryImpl: UserRepositoryImpl) : UserRepository

    @Binds
    abstract fun provideExecutor(executorImpl: ExecutorImpl) : Executor

    @Binds
    abstract fun provideModule1(module1NavigatorImpl: Module1NavigatorImpl) : Module1Navigator
}

class ExecutorImpl() : Executor {
    override fun execute(command: Runnable?) {
        command?.run()
    }
}