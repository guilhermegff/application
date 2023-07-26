package com.example.datasource

import com.example.localdatasource_api.user.UserEntity
import com.example.datasource_impl.user.UserDataBaseModel

internal interface UserDbMapperTestFixture {
    val userDataModel
        get() = object : UserEntity {
            override val name: String = "name"
            override val email: String = "email"
            override val gender: String = "gender"
            override val status: String = "status"
        }

    val userDataBaseModel
        get() = UserDataBaseModel(
            id = 1,
            name = "name",
            email = "email",
            status = "status",
            gender = "gender",
        )
}