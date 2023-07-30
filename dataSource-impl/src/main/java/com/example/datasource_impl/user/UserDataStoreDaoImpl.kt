package com.example.datasource_impl.user

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.datasource_api.user.UserDataStoreDao
import com.example.datasource_impl.dataStore

private const val ID_DATA_STORE = "id"

internal class UserDataStore(val context: Context) : UserDataStoreDao {
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