package com.example.module4_impl.presentation

import com.example.datasource_api.user.UserEntity
import com.example.module4_impl.core.model.UserDomainModel

class UserUiMapperImpl  constructor() : UserUiMapper<UserUiModel> {
    override fun transform(userEntity: UserEntity) = with(userEntity as UserDomainModel) {
        UserUiModel(
            id = id,
            name = name,
            email = email ?: "",
            gender = gender ?: "",
            status = status,
        )
    }

    override fun transform(userEntityList: List<UserEntity>) = userEntityList.map {
        with(it) {
            transform(it)
        }
    }

    companion object {
        private fun provide() = UserUiMapperImpl()
        @Suppress("UNCHECKED_CAST")
        fun newInstance(): UserUiMapper<UserEntity> = provide() as? UserUiMapper<UserEntity>
            ?: throw IllegalArgumentException("Must use UserEntity type")
    }
}