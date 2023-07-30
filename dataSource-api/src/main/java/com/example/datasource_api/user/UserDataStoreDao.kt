package com.example.datasource_api.user

interface UserDataStoreDao {
     suspend fun saveId(id: String)
     suspend fun getId()
}