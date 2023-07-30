package com.example.datasource_api.user

interface UserDataBaseFactory {
    fun provideUserDao(): UserDataBaseDao<UserEntity>
}