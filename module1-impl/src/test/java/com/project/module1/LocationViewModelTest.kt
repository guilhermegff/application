package com.project.module1

import com.project.module1.core.usecase.GetLocationList
import com.project.module1.infrastructure.LocationRepositoryImpl
import com.project.module1.infrastructure.LocationService
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

internal class LocationViewModelTest : Module1UnitTestFixture {
    @get:Rule
    val mainTestRule = MainTestRule()

    private val service: LocationService = mock(LocationService::class.java)

    @Test
    fun `viewmodel state shows correct state when successfully initialized`() = runTest {
        val locationViewModel = `given a successful path with`(service)
        val results = launchCollect(locationViewModel.state)
        assertThat(results, equalTo(initialLoading))
    }

    private suspend fun `given a successful path with`(locationService: LocationService): LocationViewModel {
        `when`(locationService.locations()).thenReturn(locationList)
        val locationRepositoryImpl = LocationRepositoryImpl(locationService)
        val getLocationList = GetLocationList(locationRepositoryImpl)
        return LocationViewModel(getLocationList)
    }

    @Test
    fun `viewmodel state shows correct state when initialized with error`() = runTest {
        val locationViewModel = `given a unsuccessful path with`(service)
        val results = launchCollect(locationViewModel.state)
        assertThat(results, equalTo(initialLoadingWithError))
    }

    @Test
    fun `viewmodel state shows correct state when initialized with error and successful retry`() =
        runTest {
            val locationViewModel = `given a unsuccessful path with`(service)
            `when`(service.locations()).thenReturn(locationList)
            locationViewModel.errorAction()
            val results = launchCollect(locationViewModel.state)
            assertThat(results, equalTo(initialLoadingWithErrorAndSuccessfulRetry))
        }

    private suspend fun `given a unsuccessful path with`(locationService: LocationService): LocationViewModel {
        val locationRepositoryImpl = LocationRepositoryImpl(locationService)
        val getLocationList = GetLocationList(locationRepositoryImpl)
        `when`(locationService.locations()).thenAnswer {
            CancellationException()
        }
        return LocationViewModel(getLocationList)
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
fun <T> TestScope.launchCollect(state: Flow<T>): List<T> {
    val results = mutableListOf<T>()
    val job = launch {
        state.collect() {
            results.add(it)
        }
    }
    advanceUntilIdle()
    job.cancel()
    for (result in results) {
        println(result)
    }
    return results
}