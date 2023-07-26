package com.example.module4_impl.presentation

import com.example.module4_impl.core.model.User
import javax.inject.Inject

class UserUiMapper @Inject constructor() {
     fun transform(user: User) = with(user) {
        UserUiModel(
            id = id ?: "",
            name = name ?: "",
            email = email ?: "",
            gender = gender ?: "",
            status = status ?: "",
        )
    }

    fun transform(userList: List<User>) = userList.map {
        with(it) {
            UserUiModel(
                id = id ?: "",
                name = name ?: "",
                email = email ?: "",
                gender = gender ?: "",
                status = status ?: "",
            )
        }
    }
}