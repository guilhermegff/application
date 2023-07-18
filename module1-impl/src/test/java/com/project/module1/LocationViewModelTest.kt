package com.project.module1

import com.project.module1.core.usecase.GetLocationList
import com.project.module1.infrastructure.LocationRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
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

    private val repo: LocationRepository = mock(LocationRepository::class.java)

    @Test
    fun `viewmodel state shows correct state when successfully initialized`() = runTest {
        val locationViewModel = `given a successful path`()
        val results = launchCollect(locationViewModel.state)
        assertThat(results, equalTo(initialLoading))
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private suspend fun `given a successful path`(): LocationViewModel {
        val getLocationList = GetLocationList(repo)
        `when`(repo.getLocationList()).thenReturn(locationList)
        return LocationViewModel(getLocationList, UnconfinedTestDispatcher())
    }

    @Test
    fun `viewmodel state shows correct state when initialized with error`() = runTest {
        val locationViewModel = `given an unsuccessful path`()
        val results = launchCollect(locationViewModel.state)
        assertThat(results, equalTo(initialLoadingWithError))
    }

    @Test
    fun `viewmodel state shows correct state when initialized with error and successful retry`() =
        runTest {
            val locationViewModel = `given an unsuccessful path`()
            `when`(repo.getLocationList()).thenReturn(locationList)
            locationViewModel.errorAction()
            val results = launchCollect(locationViewModel.state)
            assertThat(results, equalTo(initialLoadingWithErrorAndSuccessfulRetry))
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    private suspend fun `given an unsuccessful path`(): LocationViewModel {
        val getLocationList = GetLocationList(repo)
        `when`(repo.getLocationList()).thenAnswer {
            CancellationException()
        }
        return LocationViewModel(getLocationList, UnconfinedTestDispatcher())
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