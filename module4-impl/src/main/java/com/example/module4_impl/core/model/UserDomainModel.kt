package com.example.module4_impl.core.model

import com.example.datasource_api.user.UserEntity

data class UserDomainModel(
    override val id: Int,
    override val name: String,
    override val email: String,
    override val gender: String,
    override val status: String,
) : UserEntity