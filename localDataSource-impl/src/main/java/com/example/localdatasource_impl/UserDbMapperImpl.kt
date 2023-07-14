package com.example.localdatasource_impl

import com.example.localdatasource_api.UserDbMapper
import com.example.localdatasource_api.UserEntity

class UserDbMapperImpl private constructor(): UserDbMapper<UserDataBaseModel> {
    override fun transform(obj: UserEntity): UserDataBaseModel {
        return UserDataBaseModel(
            id = 1,
            name = obj.name,
            email = obj.email,
            gender = obj.gender,
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