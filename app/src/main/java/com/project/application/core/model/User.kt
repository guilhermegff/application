package com.project.application.core.model

import com.example.localdatasource_api.user.UserEntity
import com.google.gson.annotations.SerializedName
import com.project.application.infrastructure.UserDataModel

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
