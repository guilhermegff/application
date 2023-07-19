package com.example.localdatasource

import com.example.localdatasource_api.user.UserEntity
import com.example.localdatasource_impl.user.UserDataBaseModel

internal interface UserLocalDaoTestFixture {
    val userDataModel
        get() = object : UserEntity {
            override val name: String = "name"
            override val email: String = "email"
            override val gender: String = "gender"
            override val status: String = "status"

            override fun equals(other: Any?): Boolean = if (other == null || other !is UserEntity) {
                false
            } else {
                this.name == other.name && this.email == other.email && this.status == other.status && this.gender == other.gender
            }

            override fun hashCode(): Int {
                return "$name$email$gender$status".toInt()
            }
        }

    val userDataBaseModel
        get() = UserDataBaseModel(
            id = 1,
            name = "name",
            email = "email",
            status = "status",
            gender = "gender",
        )

    val expectedList
        get() = listOf(userDataModel)

    val ids
        get() = intArrayOf(1)

    val token
        get() = "token"
}