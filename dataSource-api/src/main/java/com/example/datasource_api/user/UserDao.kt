package com.example.datasource_api.user

interface UserDao : UserDataBaseDao<UserEntity>, UserSharedPreferencesDao,
    UserDataStoreDao, UserRemoteDao {}