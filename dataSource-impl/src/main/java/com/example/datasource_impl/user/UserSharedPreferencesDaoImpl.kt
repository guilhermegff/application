package com.example.datasource_impl.user

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.datasource_api.user.UserSharedPreferencesDao

internal class UserSharedPreferencesDaoImpl private constructor(private val sharedPreferences: SharedPreferences) :
    UserSharedPreferencesDao {
    override fun saveToken(token: String) {
        sharedPreferences.edit {
            putString(TOKEN_KEY, token)
        }
    }

    override fun retrieveToken(): String = try {
        sharedPreferences.getString(TOKEN_KEY, "") ?: ""
    } catch (exception: Exception) {
        ""
    }

    companion object {
        const val TOKEN_KEY = "Token"
        fun newInstance(sharedPreferences: SharedPreferences): UserSharedPreferencesDao =
            UserSharedPreferencesDaoImpl(sharedPreferences)
    }
}