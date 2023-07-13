package com.project.application.infrastructure

import com.example.localdatasource_api.UserDaoContract
import com.example.localdatasource_api.UserEntity
import com.example.localdatasource_impl.UserDataBaseModel
import com.project.application.core.model.User
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService,
    private val userDao: UserDaoContract<UserEntity>,
) : UserRepository {
    val mapper = DBMapper()

    override suspend fun getUser(id: String): User {
        //userDao.getAll()
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
        /*UserDataModel(
                name = "name",
                email = "email",
                gender = "gender",
                status = "status",
            )*/
    }
}

class DBMapper() {
    fun transform(obj: UserEntity) : UserEntity {
        return UserDataBaseModel(
            id = 1,
            name = obj.name,
            email = obj.email,
            gender = obj.gender,
            status = obj.status,
        )
    }
}