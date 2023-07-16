package com.example.localdatasource_api.user

interface UserSharedPreferencesDaoContract {
    fun saveToken(token: String)
}