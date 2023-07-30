package com.example.module4_impl.infrastructure

import com.example.datasource_api.user.UserDao
import com.example.module4_impl.core.UserDomainMapper
import com.example.module4_impl.core.model.UserDomainModel
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val userDomainMapper: UserDomainMapper,
) : UserRepository<UserDomainModel> {

    override suspend fun fetchUser(id: String) = userDomainMapper.transform(userDao.user(id))

    override suspend fun getUserList(): List<UserDomainModel> {
        println("Repo ${Thread.currentThread().name}")
        return userDomainMapper.transform(userDao.users())
    }

    override suspend fun saveUser(userEntity: UserDomainModel) {
        userDao.insertAll(userEntity)
    }

    override suspend fun queryUser(id: Int): UserDomainModel {
        return userDomainMapper.transform(userDao.getAll().first())
    }

    override suspend fun saveToken(token: String) {
        userDao.saveToken(token)
    }

    override suspend fun retrieveToken(): String {
        return userDao.retrieveToken()
    }

    override suspend fun saveId(id: String) {
        userDao.saveId(id)
    }

    override suspend fun getId() {
        userDao.getId()
    }
}