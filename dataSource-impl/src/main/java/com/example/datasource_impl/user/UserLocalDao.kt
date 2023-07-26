package com.example.datasource_impl.user

import com.example.datasource_api.user.*
import javax.inject.Inject

class UserLocalDao @Inject constructor(
    private val userDaoContract: UserDaoContract<UserEntity>,
    private val userDbMapper: UserDbMapper<UserEntity>,
    private val shared: UserSharedPreferencesDaoContract,
    private val store: UserDataStoreDaoContract,
) : UserLocalDaoContract {

    override fun getAll(): List<UserEntity> {
        return userDaoContract.getAll()
    }

    override fun loadAllByIds(userIds: IntArray): List<UserEntity> {
        return userDaoContract.loadAllByIds(userIds)
    }

    override fun findByName(first: String): UserEntity {
        return userDaoContract.findByName(first)
    }

    override fun insertAll(users: UserEntity) {
        userDaoContract.insertAll(userDbMapper.transform(users))
    }

    override fun delete(user: UserEntity) {
        userDaoContract.delete(userDbMapper.transform(user))
    }

    override fun saveToken(token: String) {
        shared.saveToken(token)
    }

    override suspend fun saveId(id: String) {
        store.saveId(id)
    }

    override suspend fun getId() {
        store.getId()
    }
}