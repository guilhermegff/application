package com.project.application.infrastructure

import com.example.localdatasource_api.user.UserEntity

data class UserDataModel(
    //override val id: Int,
    override val name: String,
    override val email: String,
    override val gender: String,
    override val status: String,
) : UserEntity