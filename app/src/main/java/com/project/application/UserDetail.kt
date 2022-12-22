package com.project.application

import com.google.gson.annotations.SerializedName

data class UserDetail(
    @SerializedName("id")
    val id: String,
)