package com.project.application.presentation

import com.project.application.core.UserDetail
import javax.inject.Inject

class UserDetailUiMapper @Inject constructor() {
     fun transform(userDetail: UserDetail) = with(userDetail) {
        UserDetailUiModel(
            id = id,
            name = name,
            email = email,
            gender = gender,
            status = status,
        )
    }
}