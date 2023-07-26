package com.example.datasource_api.user

interface UserDataStoreDaoContract {
     suspend fun saveId(id: String)
     suspend fun getId()
}