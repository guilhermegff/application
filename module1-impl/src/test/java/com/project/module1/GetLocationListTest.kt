package com.project.module1

import com.project.module1.core.usecase.GetLocationList
import com.project.module1.infrastructure.LocationRepository
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class GetLocationListTest : Module1UnitTestFixture {

    @get:Rule
    val mainTestRule = MainTestRule()

    private val locationRepository: LocationRepository = mock(LocationRepository::class.java)

    private val getLocationList = GetLocationList(locationRepository)

    @Test
    fun `location repository is called inside use case`() = runTest {
        getLocationList()
        verify(locationRepository, times(1)).getLocationList()
    }
}