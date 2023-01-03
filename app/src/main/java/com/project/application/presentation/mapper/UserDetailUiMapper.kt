package com.project.application.presentation.mapper

import com.project.application.core.model.UserDetail
import com.project.application.presentation.model.UserDetailUiModel
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