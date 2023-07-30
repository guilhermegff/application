package com.example.module4_impl.presentation

import com.example.datasource_api.user.UserEntity

interface UserUiMapper<out T : UserEntity> {
    fun transform(userEntity: UserEntity): T
    fun transform(userEntityList: List<UserEntity>): List<T>
}