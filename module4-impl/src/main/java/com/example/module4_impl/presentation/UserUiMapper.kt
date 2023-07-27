package com.example.module4_impl.presentation

import com.example.module4_impl.core.model.UserDomainModel
import javax.inject.Inject

class UserUiMapper @Inject constructor() {
    fun transform(user: UserDomainModel) = with(user) {
        UserUiModel(
            id = id.toString() ?: "",
            name = name ?: "",
            email = email ?: "",
            gender = gender ?: "",
            status = status ?: "",
        )
    }

    fun transform(userList: List<UserDomainModel>) = userList.map {
        with(it) {
            transform(it)
        }
    }
}