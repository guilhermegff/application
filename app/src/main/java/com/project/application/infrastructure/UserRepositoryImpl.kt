package com.project.application.infrastructure

import com.project.application.core.model.User
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService,
): UserRepository {
    override suspend fun getUser(id: String): User {
        return userService.user(id)
    }

    override suspend fun getUserList(): List<User> {
        println("Repo ${Thread.currentThread().name}")
        return userService.users()
    }
}