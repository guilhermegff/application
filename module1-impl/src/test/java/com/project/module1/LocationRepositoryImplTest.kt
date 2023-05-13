package com.project.module1

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
    private val locationRepositoryImpl = LocationRepositoryImpl(service)

    @Test
    fun `getLocationList returns list of location`() = runBlocking {
        val result = locationRepositoryImpl.getLocationList()
        assertThat(result.size, equalTo(locationList.size) )
    }
}