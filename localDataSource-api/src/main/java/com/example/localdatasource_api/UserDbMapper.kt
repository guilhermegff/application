package com.example.localdatasource_api

interface UserDbMapper<T: UserEntity> {
    fun transform(obj: UserEntity) : T
}