package com.example.localdatasource_api.user

interface UserLocalDaoContract : UserDaoContract<UserEntity>, UserSharedPreferencesDaoContract,
    UserDataStoreDaoContract {}