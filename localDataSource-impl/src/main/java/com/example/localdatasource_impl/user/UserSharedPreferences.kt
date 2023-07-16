package com.example.localdatasource_impl.user

import com.example.localdatasource_api.user.UserSharedPreferencesDaoContract

class UserSharedPreferences : UserSharedPreferencesDaoContract {
    override fun saveToken(token: String) {
        println(token)
    }
}