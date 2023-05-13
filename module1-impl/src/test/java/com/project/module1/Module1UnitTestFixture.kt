package com.project.module1

import com.project.module1.core.Location
import com.project.module1.presentation.LocationUiModel

internal interface Module1UnitTestFixture {

    val locationList
        get() = listOf<Location>(
            Location("A"),
            Location("B"),
            Location("C")
        )

    val uiModelLocationList
        get() = listOf<LocationUiModel>(
            LocationUiModel("A"),
            LocationUiModel("B"),
            LocationUiModel("C")
        )

    val initialLoading
        get() = listOf(
            LocationViewModel.ViewState(
                isLoading = true,
                isError = false,
                emptyList()
            ),
            LocationViewModel.ViewState(
                isLoading = false,
                isError = false,
                uiModelLocationList
            )
        )

    val initialLoadingWithError
        get() = listOf(
            LocationViewModel.ViewState(
                isLoading = true,
                isError = false,
                emptyList()
            ),
            LocationViewModel.ViewState(
                isLoading = false,
                isError = true,
                emptyList()
            )
        )

    val initialLoadingWithErrorAndSuccessfulRetry
        get() = listOf(
            LocationViewModel.ViewState(isLoading = true, isError = false, emptyList()),
            LocationViewModel.ViewState(isLoading = false, isError = true, emptyList()),
            LocationViewModel.ViewState(isLoading = true, isError = false, emptyList()),
            LocationViewModel.ViewState(isLoading = false, isError = false, uiModelLocationList)
        )
}