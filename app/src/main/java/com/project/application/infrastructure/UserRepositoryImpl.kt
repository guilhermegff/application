package com.project.application.infrastructure

import com.example.localdatasource_api.UserDaoContract
import com.example.localdatasource_api.UserDbMapper
import com.example.localdatasource_api.UserEntity
import com.project.application.core.model.User
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService,
    private val userDao: UserDaoContract<UserEntity>,
    private val mapper: UserDbMapper<UserEntity>,
) : UserRepository {

    override suspend fun getUser(id: String): User {
        return userService.user(id)
    }

    override suspend fun getUserList(): List<User> {
        println("Repo ${Thread.currentThread().name}")
        return userService.users()
    }

    override suspend fun saveUser(userEntity: UserEntity) {
        userDao.insertAll(mapper.transform(userEntity))
    }

    override suspend fun fetchUser(id: Int): UserEntity {
        return userDao.getAll().first()
    }
}