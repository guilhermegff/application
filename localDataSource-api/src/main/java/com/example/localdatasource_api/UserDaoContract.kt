package com.example.localdatasource_api

interface UserDaoContract<T: UserEntity> {
     fun getAll(): List<T>
     fun loadAllByIds(userIds: IntArray): List<T>
     fun findByName(first: String): UserEntity
     fun insertAll(users: T)
     fun delete(user: T)
}