package com.example.localdatasource_impl.location

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.localdatasource_api.location.LocationEntity

@Entity
data class LocationDataBaseModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "name")
    override val name: String,
) : LocationEntity