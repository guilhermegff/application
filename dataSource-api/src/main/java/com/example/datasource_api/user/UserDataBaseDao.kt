package com.example.datasource_api.user

interface UserDataBaseDao<T: UserEntity> {
     fun getAll(): List<T>
     fun loadAllByIds(userIds: IntArray): List<T>
     fun findByName(first: String): UserEntity
     fun insertAll(users: T)
     fun delete(user: T)
}