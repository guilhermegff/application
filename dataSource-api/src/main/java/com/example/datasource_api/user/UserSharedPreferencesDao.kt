package com.example.datasource_api.user

interface UserSharedPreferencesDao {
    fun saveToken(token: String)
    fun retrieveToken(): String
}