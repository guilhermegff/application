package com.example.datasource_api.user

interface UserLocalDaoContract : UserDaoContract<UserEntity>, UserSharedPreferencesDaoContract,
    UserDataStoreDaoContract {}