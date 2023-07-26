package com.example.module4_impl.infrastructure

import com.example.datasource_api.user.UserEntity

data class UserDataModel(
    //override val id: Int,
    override val name: String,
    override val email: String,
    override val gender: String,
    override val status: String,
) : UserEntity