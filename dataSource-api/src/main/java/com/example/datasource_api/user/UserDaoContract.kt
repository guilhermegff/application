package com.example.datasource_api.user

interface UserDaoContract : UserDataBaseDaoContract<UserEntity>, UserSharedPreferencesDaoContract,
    UserDataStoreDaoContract {}