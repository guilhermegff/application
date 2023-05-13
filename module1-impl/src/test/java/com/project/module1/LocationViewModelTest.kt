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
import org.mockito.Mockito
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

internal class LocationViewModelTest : Module1UnitTestFixture {
    @get:Rule
    val mainTestRule = MainTestRule()

    @Test
    fun `viewmodel state shows correct loading state when initialized`() = runTest {
        val locationViewModel = `given a successful path`()
        val results = launchCollect(locationViewModel.state)
        println(results)
        assertThat(results[0].isLoading, equalTo(true))
        assertThat(results[1].isLoading, equalTo(false))
    }

    private fun `given a successful path`(): LocationViewModel {
        val service: LocationService = Mockito.mock(LocationService::class.java) {
            return@mock locationList
        }
        val locationRepositoryImpl = LocationRepositoryImpl(service)
        val getLocationList = GetLocationList(locationRepositoryImpl)
        return LocationViewModel(getLocationList)
    }

    @Test
    fun `viewmodel state shows correct ui model state when initialized`() = runTest {
        val locationViewModel = `given a successful path`()
        val results = launchCollect(locationViewModel.state)
        println(results)
        assertThat(results[0].locationUiModelList, equalTo(emptyList()))
        assertThat(results[1].locationUiModelList, equalTo(uiModelLocationList))
    }

    @Test
    fun `viewmodel state shows correct error state when initialized with error`() = runTest {
        val locationViewModel = `given a unsuccessful path`()
        val results = launchCollect(locationViewModel.state)
        println(results)
        assertThat(results[0].isError, equalTo(false))
        assertThat(results[1].isError, equalTo(true))
    }

    private fun `given a unsuccessful path`(): LocationViewModel {
        val service: LocationService = Mockito.mock(LocationService::class.java) {
            throw CancellationException()
        }
        val locationRepositoryImpl = LocationRepositoryImpl(service)
        val getLocationList = GetLocationList(locationRepositoryImpl)
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
    return results
}