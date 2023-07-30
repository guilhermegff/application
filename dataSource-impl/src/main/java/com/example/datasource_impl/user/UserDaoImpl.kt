package com.example.datasource_impl.user

import com.example.datasource_api.user.*
import javax.inject.Inject

class UserDaoImpl @Inject constructor(
    private val userDataBaseDao: UserDataBaseDao<UserEntity>,
    private val userDbMapper: UserDbMapper<UserEntity>,
    private val shared: UserSharedPreferencesDao,
    private val store: UserDataStoreDao,
    private val service: UserRemoteDao,
) : UserDao {

    override suspend fun user(id: String): UserEntity {
        return service.user(id)
    }

    override suspend fun users(): List<UserEntity> {
        return service.users()
    }

    override fun getAll(): List<UserEntity> {
        return userDataBaseDao.getAll()
    }

    override fun loadAllByIds(userIds: IntArray): List<UserEntity> {
        return userDataBaseDao.loadAllByIds(userIds)
    }

    override fun findByName(first: String): UserEntity {
        return userDataBaseDao.findByName(first)
    }

    override fun insertAll(users: UserEntity) {
        userDataBaseDao.insertAll(userDbMapper.transform(users))
    }

    override fun delete(user: UserEntity) {
        userDataBaseDao.delete(userDbMapper.transform(user))
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