package com.example.datasource_impl

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.datasource_api.AppDatabaseContractFactory
import com.example.datasource_api.location.LocationDaoContract
import com.example.datasource_api.location.LocationEntity
import com.example.datasource_api.user.UserDaoContract
import com.example.datasource_api.user.UserEntity
import com.example.datasource_impl.location.LocationDao
import com.example.datasource_impl.location.LocationDataBaseModel
import com.example.datasource_impl.user.UserDao
import com.example.datasource_impl.user.UserDataBaseModel

@Database(entities = [UserDataBaseModel::class, LocationDataBaseModel::class], version = 1)
internal abstract class AppDatabase : AppDatabaseContractFactory, RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun locationDao(): LocationDao

    @Suppress("UNCHECKED_CAST")
    final override fun provideUserDao(): UserDaoContract<UserEntity> =
        userDao() as? UserDaoContract<UserEntity>
            ?: throw IllegalArgumentException("Must use UserEntity type")

    @Suppress("UNCHECKED_CAST")
    final override fun provideLocationDao(): LocationDaoContract<LocationEntity> =
        locationDao() as? LocationDaoContract<LocationEntity>
            ?: throw IllegalArgumentException("Must use LocationEntity type")

    companion object {
        fun newInstance(context: Context): AppDatabase = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()
    }
}