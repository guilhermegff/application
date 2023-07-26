package com.example.datasource_api.user

interface UserDataBaseContractFactory {
    fun provideUserDao(): UserDataBaseDaoContract<UserEntity>
}