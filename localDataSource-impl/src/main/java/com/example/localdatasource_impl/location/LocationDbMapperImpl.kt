package com.example.localdatasource_impl.location

import com.example.localdatasource_api.location.LocationDbMapper
import com.example.localdatasource_api.location.LocationEntity

class LocationDbMapperImpl private constructor() : LocationDbMapper<LocationDataBaseModel> {
    override fun transform(obj: LocationEntity): LocationDataBaseModel {
        return LocationDataBaseModel(
            id = 1,
            name = obj.name,
        )
    }

    companion object {
        private fun provide() = LocationDbMapperImpl()

        @Suppress("UNCHECKED_CAST")
        fun newInstance(): LocationDbMapper<LocationEntity> =
            provide() as? LocationDbMapper<LocationEntity>
                ?: throw IllegalArgumentException("Must use LocationEntity type")
    }
}