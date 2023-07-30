package com.example.datasource_impl

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.datasource_api.AppDatabaseFactory
import com.example.datasource_api.location.LocationDao
import com.example.datasource_api.location.LocationEntity
import com.example.datasource_api.user.UserDataBaseDao
import com.example.datasource_api.user.UserEntity
import com.example.datasource_impl.location.LocationDataBase
import com.example.datasource_impl.location.LocationDataBaseModel
import com.example.datasource_impl.user.UserDataBase
import com.example.datasource_impl.user.UserDataBaseModel

@Database(entities = [UserDataBaseModel::class, LocationDataBaseModel::class], version = 1)
internal abstract class AppDatabase : AppDatabaseFactory, RoomDatabase() {
    abstract fun userDao(): UserDataBase
    abstract fun locationDao(): LocationDataBase

    @Suppress("UNCHECKED_CAST")
    final override fun provideUserDao(): UserDataBaseDao<UserEntity> =
        userDao() as? UserDataBaseDao<UserEntity>
            ?: throw IllegalArgumentException("Must use UserEntity type")

    @Suppress("UNCHECKED_CAST")
    final override fun provideLocationDao(): LocationDao<LocationEntity> =
        locationDao() as? LocationDao<LocationEntity>
            ?: throw IllegalArgumentException("Must use LocationEntity type")

    companion object {
        fun newInstance(context: Context): AppDatabase = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()
    }
}