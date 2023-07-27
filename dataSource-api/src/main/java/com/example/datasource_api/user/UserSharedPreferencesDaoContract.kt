package com.example.datasource_api.user

interface UserSharedPreferencesDaoContract {
    fun saveToken(token: String)
    fun retrieveToken(): String
}