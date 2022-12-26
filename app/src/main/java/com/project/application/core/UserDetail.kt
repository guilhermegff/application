package com.project.application.core

import com.google.gson.annotations.SerializedName

data class UserDetail(
    @SerializedName("id")
    val id: String,
)