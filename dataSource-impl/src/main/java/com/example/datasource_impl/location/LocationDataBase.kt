package com.example.datasource_impl.location

import androidx.room.*
import com.example.datasource_api.location.LocationDao

@Dao
interface LocationDataBase : LocationDao<LocationDataBaseModel> {
    @Query("SELECT * FROM locationDataBaseModel")
    abstract override fun getAll(): List<LocationDataBaseModel>

    @Query("SELECT * FROM locationDataBaseModel WHERE id IN (:locationIds)")
    abstract override fun loadAllByIds(locationIds: IntArray): List<LocationDataBaseModel>

    @Query("SELECT * FROM locationDataBaseModel WHERE name LIKE :first LIMIT 1")
    abstract override fun findByName(first: String): LocationDataBaseModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract override fun insertAll(locations: LocationDataBaseModel)

    @Delete
    abstract override fun delete(location: LocationDataBaseModel)
}