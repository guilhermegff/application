package com.example.datasource_api.user

interface UserDbMapper<T: UserEntity> {
    fun transform(obj: UserEntity) : T
}