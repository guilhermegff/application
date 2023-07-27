package com.example.datasource_impl.user

import com.example.datasource_api.user.*
import javax.inject.Inject

class UserDao @Inject constructor(
    private val userDataBaseDaoContract: UserDataBaseDaoContract<UserEntity>,
    private val userDbMapper: UserDbMapper<UserEntity>,
    private val shared: UserSharedPreferencesDaoContract,
    private val store: UserDataStoreDaoContract,
    private val service: UserService,
) : UserDaoContract {

    override suspend fun user(id: String): UserEntity {
        return service.user(id)
    }

    override suspend fun users(): List<UserEntity> {
        return service.users()
    }

    override fun getAll(): List<UserEntity> {
        return userDataBaseDaoContract.getAll()
    }

    override fun loadAllByIds(userIds: IntArray): List<UserEntity> {
        return userDataBaseDaoContract.loadAllByIds(userIds)
    }

    override fun findByName(first: String): UserEntity {
        return userDataBaseDaoContract.findByName(first)
    }

    override fun insertAll(users: UserEntity) {
        userDataBaseDaoContract.insertAll(userDbMapper.transform(users))
    }

    override fun delete(user: UserEntity) {
        userDataBaseDaoContract.delete(userDbMapper.transform(user))
    }

    override fun saveToken(token: String) {
        shared.saveToken(token)
    }

    override fun retrieveToken(): String {
        return shared.retrieveToken()
    }

    override suspend fun saveId(id: String) {
        store.saveId(id)
    }

    override suspend fun getId() {
        store.getId()
    }
}