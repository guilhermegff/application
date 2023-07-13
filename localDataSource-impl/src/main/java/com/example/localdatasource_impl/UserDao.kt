package com.example.localdatasource_impl

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.localdatasource_api.UserDaoContract

@Dao
abstract class UserDao : UserDaoContract<UserDataBaseModel> {
    @Query("SELECT * FROM userDataBaseModel")
    abstract override fun getAll(): List<UserDataBaseModel>

    @Query("SELECT * FROM userDataBaseModel WHERE id IN (:userIds)")
    abstract override fun loadAllByIds(userIds: IntArray): List<UserDataBaseModel>

    @Query("SELECT * FROM userDataBaseModel WHERE name LIKE :first LIMIT 1")
    abstract override fun findByName(first: String): UserDataBaseModel

    @Insert
    abstract override fun insertAll(users: UserDataBaseModel)

    @Delete
    abstract override fun delete(user: UserDataBaseModel)
}