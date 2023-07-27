package com.example.datasource_impl.user

import com.example.datasource_api.user.UserEntity
import com.google.gson.annotations.SerializedName

data class UserResponseModel(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("name")
    override val name: String,
    @SerializedName("email")
    override val email: String,
    @SerializedName("gender")
    override val gender: String,
    @SerializedName("status")
    override val status: String,
) : UserEntity