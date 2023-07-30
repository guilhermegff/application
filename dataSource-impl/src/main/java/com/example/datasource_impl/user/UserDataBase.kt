package com.example.datasource_impl.user

import androidx.room.*
import com.example.datasource_api.user.UserDataBaseDao

@Dao
abstract class UserDataBase : UserDataBaseDao<UserDataBaseModel> {
    @Query("SELECT * FROM userDataBaseModel")
    abstract override fun getAll(): List<UserDataBaseModel>

    @Query("SELECT * FROM userDataBaseModel WHERE id IN (:userIds)")
    abstract override fun loadAllByIds(userIds: IntArray): List<UserDataBaseModel>

    @Query("SELECT * FROM userDataBaseModel WHERE name LIKE :first LIMIT 1")
    abstract override fun findByName(first: String): UserDataBaseModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract override fun insertAll(users: UserDataBaseModel)

    @Delete
    abstract override fun delete(user: UserDataBaseModel)
}