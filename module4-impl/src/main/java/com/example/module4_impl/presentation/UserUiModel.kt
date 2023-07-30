package com.example.module4_impl.presentation

import com.example.datasource_api.user.UserEntity

data class UserUiModel(
    override val id: Int = 0,
    override val name: String = "",
    override val email: String = "",
    override val gender: String = "",
    override val status: String = "",
) : UserEntity