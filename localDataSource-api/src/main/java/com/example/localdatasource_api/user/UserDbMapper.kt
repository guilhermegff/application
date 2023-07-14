package com.example.localdatasource_api.user

interface UserDbMapper<T: UserEntity> {
    fun transform(obj: UserEntity) : T
}