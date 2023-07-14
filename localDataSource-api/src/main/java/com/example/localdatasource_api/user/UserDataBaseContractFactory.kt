package com.example.localdatasource_api.user

interface UserDataBaseContractFactory {
    fun provideUserDao(): UserDaoContract<UserEntity>
}