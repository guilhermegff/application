package com.example.localdatasource_impl

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.localdatasource_api.AppDatabaseApi
import com.example.localdatasource_api.UserDaoContract
import com.example.localdatasource_api.UserEntity

@Database(entities = [UserDataBaseModel::class], version = 1)
abstract class AppDatabase : AppDatabaseApi, RoomDatabase() {
    abstract fun userDao(): UserDao

    @Suppress("UNCHECKED_CAST")
    override fun provideUserDao(): UserDaoContract<UserEntity> =
        userDao() as? UserDaoContract<UserEntity>
            ?: throw IllegalArgumentException("Must use UserEntity type")

    companion object {
        fun newInstance(context: Context): AppDatabase = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()
    }
}