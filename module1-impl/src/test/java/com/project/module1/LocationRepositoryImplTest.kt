package com.project.module1

import com.example.datasource_api.location.LocationDao
import com.example.datasource_api.location.LocationDbMapper
import com.example.datasource_api.location.LocationEntity
import com.project.module1.infrastructure.LocationRepositoryImpl
import com.project.module1.infrastructure.LocationService
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Test
import org.mockito.Mockito.mock

class LocationRepositoryImplTest : Module1UnitTestFixture {

    private val service : LocationService = mock(LocationService::class.java) {
        return@mock locationList
    }

    @Suppress("UNCHECKED_CAST")
    private val dao: LocationDao<LocationEntity> = mock(LocationDao::class.java) as LocationDao<LocationEntity>
    @Suppress("UNCHECKED_CAST")
    private val mapper: LocationDbMapper<LocationEntity> = mock(LocationDbMapper::class.java) as LocationDbMapper<LocationEntity>
    private val locationRepositoryImpl = LocationRepositoryImpl(service, dao, mapper)

    @Test
    fun `getLocationList returns list of location`() = runBlocking {
        val result = locationRepositoryImpl.getLocationList()
        assertThat(result.size, equalTo(locationList.size) )
    }
}