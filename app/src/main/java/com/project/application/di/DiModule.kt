package com.project.application.di

import com.project.application.infrastructure.UserRepository
import com.project.application.infrastructure.UserRepositoryImpl
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
}

class ExecutorImpl() : Executor {
    override fun execute(command: Runnable?) {
        command?.run()
    }
}