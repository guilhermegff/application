package com.example.localdatasource_impl.user

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.localdatasource_api.user.UserSharedPreferencesDaoContract

internal class UserSharedPreferences private constructor(private val sharedPreferences: SharedPreferences) :
    UserSharedPreferencesDaoContract {
    override fun saveToken(token: String) {
        sharedPreferences.edit {
            putString("Token", token)
        }
        val savedToken = sharedPreferences.getString("Token", "")
        println("Saved token: $savedToken")
    }

    companion object {
        fun newInstance(sharedPreferences: SharedPreferences): UserSharedPreferencesDaoContract =
            UserSharedPreferences(sharedPreferences)
    }
}