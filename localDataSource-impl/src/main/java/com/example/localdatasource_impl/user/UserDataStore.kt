package com.example.localdatasource_impl.user

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.localdatasource_api.user.UserDataStoreDaoContract
import com.example.localdatasource_impl.dataStore

private const val ID_DATA_STORE = "id"

internal class UserDataStore(val context: Context) : UserDataStoreDaoContract {
    override suspend fun saveId(id: String) {
        context.dataStore.edit { dataStore ->
            dataStore[stringPreferencesKey(ID_DATA_STORE)] = id
        }
    }

    override suspend fun getId() {
        var a: String = ""
        context.dataStore.edit { dataStore ->
            a = dataStore[stringPreferencesKey(ID_DATA_STORE)] ?: "NotFound"
        }
        println("Data Store: $a")
    }
}