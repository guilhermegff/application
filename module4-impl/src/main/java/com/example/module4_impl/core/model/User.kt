package com.example.module4_impl.core.model

import com.example.localdatasource_api.user.UserEntity
import com.example.module4_impl.infrastructure.UserDataModel
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("status")
    val status: String?,
)

fun User.toDataModel() : UserEntity = UserDataModel(
    //id = 1,
    name = "name",
    email = "email",
    gender = "gender",
    status = "status"
)
