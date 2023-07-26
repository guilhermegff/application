package com.example.module4_impl.infrastructure

import com.example.datasource_api.user.UserEntity
import com.example.datasource_api.user.UserLocalDaoContract
import com.example.module4_impl.core.model.User
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService,
    private val userLocalDao: UserLocalDaoContract,
) : UserRepository {

    override suspend fun fetchUser(id: String): User {
        return userService.user(id)
    }

    override suspend fun getUserList(): List<User> {
        println("Repo ${Thread.currentThread().name}")
        return userService.users()
    }

    override suspend fun saveUser(userEntity: UserEntity) {
        userLocalDao.insertAll(userEntity)
    }

    override suspend fun queryUser(id: Int): UserEntity {
        return userLocalDao.getAll().first()
    }

    override suspend fun saveToken(token: String) {
        userLocalDao.saveToken(token)
    }

    override suspend fun saveId(id: String) {
        userLocalDao.saveId(id)
    }

    override suspend fun getId() {
        userLocalDao.getId()
    }
}