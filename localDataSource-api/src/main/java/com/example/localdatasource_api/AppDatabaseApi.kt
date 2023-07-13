package com.example.localdatasource_api

interface AppDatabaseApi : UserDataBaseApi {
}

interface UserDataBaseApi {
    fun provideUserDao(): UserDaoContract<UserEntity>
}