package com.example.datasource_api.user

interface UserDataBaseContractFactory {
    fun provideUserDao(): UserDaoContract<UserEntity>
}