package com.project.application

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.Executor

@Module
@InstallIn(SingletonComponent::class)
abstract class DiModule() {

    @Binds
    abstract fun provideRepo(mainRepositoryImpl: MainRepositoryImpl) : MainRepository

    @Binds
    abstract fun provideExecutor(executorImpl: ExecutorImpl) : Executor
}

class ExecutorImpl() : Executor {
    override fun execute(command: Runnable?) {
        command?.run()
    }
}