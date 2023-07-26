package com.example.localdatasource_api.user

import com.example.localdatasource_api.LocalDataSourceResult

interface UserSharedPreferencesDaoContract {
    fun saveToken(token: String)
    //fun retrieveToken(): LocalDataSourceResult
}