package com.example.module4_impl.infrastructure

import com.example.datasource_api.user.UserDaoContract
import com.example.module4_impl.core.UserDomainMapper
import com.example.module4_impl.core.model.UserDomainModel
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDaoContract: UserDaoContract,
    private val userDomainMapper: UserDomainMapper,
) : UserRepository<UserDomainModel> {

    override suspend fun fetchUser(id: String) = userDomainMapper.transform(userDaoContract.user(id))

    override suspend fun getUserList(): List<UserDomainModel> {
        println("Repo ${Thread.currentThread().name}")
        return userDomainMapper.transform(userDaoContract.users())
    }

    override suspend fun saveUser(userEntity: UserDomainModel) {
        userDaoContract.insertAll(userEntity)
    }

    override suspend fun queryUser(id: Int): UserDomainModel {
        return userDomainMapper.transform(userDaoContract.getAll().first())
    }

    override suspend fun saveToken(token: String) {
        userDaoContract.saveToken(token)
    }

    override suspend fun retrieveToken(): String {
        return userDaoContract.retrieveToken()
    }

    override suspend fun saveId(id: String) {
        userDaoContract.saveId(id)
    }

    override suspend fun getId() {
        userDaoContract.getId()
    }
}