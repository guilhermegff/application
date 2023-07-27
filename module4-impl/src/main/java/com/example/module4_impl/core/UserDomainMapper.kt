package com.example.module4_impl.core

import com.example.datasource_api.user.UserEntity
import com.example.module4_impl.core.model.UserDomainModel

class UserDomainMapper {
    fun transform(obj: UserEntity): UserDomainModel = UserDomainModel(
        id = obj.id,
        name = obj.name,
        email = obj.email ?: "",
        gender = obj.gender ?: "",
        status = obj.status,
    )

    fun transform(collection: List<UserEntity>): List<UserDomainModel> {
        val mutableList = arrayListOf<UserDomainModel>()
        for (obj in collection) {
            mutableList.add(
                transform(obj)
            )
        }
        return mutableList
    }
}