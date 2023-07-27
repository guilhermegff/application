package com.example.datasource_impl.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.datasource_api.user.UserEntity

@Entity
data class UserDataBaseModel(
    @PrimaryKey(autoGenerate = true)
    override val id: Int,
    @ColumnInfo(name = "name")
    override val name: String,
    override val email: String,
    override val gender: String,
    override val status: String
) : UserEntity
