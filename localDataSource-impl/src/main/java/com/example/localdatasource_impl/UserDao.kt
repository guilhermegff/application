package com.example.localdatasource_impl

import androidx.room.*
import com.example.localdatasource_api.user.UserDaoContract

@Dao
abstract class UserDao : UserDaoContract<UserDataBaseModel> {
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