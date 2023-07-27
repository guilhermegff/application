package com.example.datasource_impl.user

import com.example.datasource_api.user.UserDbMapper
import com.example.datasource_api.user.UserEntity

internal class UserDbMapperImpl private constructor(): UserDbMapper<UserDataBaseModel> {
    override fun transform(obj: UserEntity): UserDataBaseModel {
        return UserDataBaseModel(
            id = 1,
            name = obj.name,
            email = obj.email ?: "",
            gender = obj.gender ?: "",
            status = obj.status,
        )
    }

    companion object {
        private fun provide() = UserDbMapperImpl()
        @Suppress("UNCHECKED_CAST")
        fun newInstance(): UserDbMapper<UserEntity> = provide() as? UserDbMapper<UserEntity>
            ?: throw IllegalArgumentException("Must use UserEntity type")
    }
}