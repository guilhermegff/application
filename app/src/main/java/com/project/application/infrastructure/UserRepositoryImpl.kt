package com.project.application.infrastructure

import com.example.localdatasource_api.user.UserEntity
import com.example.localdatasource_api.user.UserLocalDaoContract
import com.project.application.core.model.User
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService,
    private val userLocalDao: UserLocalDaoContract,
) : UserRepository {

    override suspend fun getUser(id: String): User {
        return userService.user(id)
    }

    override suspend fun getUserList(): List<User> {
        println("Repo ${Thread.currentThread().name}")
        return userService.users()
    }

    override suspend fun saveUser(userEntity: UserEntity) {
        userLocalDao.insertAll(userEntity)
    }

    override suspend fun fetchUser(id: Int): UserEntity {
        return userLocalDao.getAll().first()
    }

    override suspend fun saveToken(token: String) {
        userLocalDao.saveToken(token)
    }
}