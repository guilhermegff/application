package com.project.application.presentation.mapper

import com.project.application.core.model.User
import com.project.application.presentation.model.UserUiModel
import javax.inject.Inject

class UserUiMapper @Inject constructor() {
     fun transform(user: User) = with(user) {
        UserUiModel(
            id = id,
            name = name,
            email = email,
            gender = gender,
            status = status,
        )
    }

    fun transform(userList: List<User>) = userList.map {
        with(it) {
            UserUiModel(
                id = id,
                name = name,
                email = email,
                gender = gender,
                status = status,
            )
        }
    }
}