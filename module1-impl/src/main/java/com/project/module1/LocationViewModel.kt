package com.project.module1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.module1.core.usecase.GetLocationList
import com.project.module1.presentation.LocationUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class LocationViewModel @Inject constructor(
    private val getLocationList: GetLocationList,
) : ViewModel() {

    private val _state = MutableStateFlow(ViewState())

    val state: StateFlow<ViewState> = _state

    init {
        initializeScreenData()
    }

    fun initializeScreenData() {
        println("Before Launch ${Thread.currentThread().name}")
        viewModelScope.launch {
            println("On Launch ${Thread.currentThread().name}")
            _state.update {
                it.copy(
                    isLoading = true,
                )
            }
            delay(1000)
            runCatching {
                println("Run ${Thread.currentThread().name}")
                getLocationList()
            }.onSuccess { locationList ->
                println("Success ${Thread.currentThread().name}")
                _state.update {
                    it.copy(
                        isLoading = false,
                        isError = false,
                        locationUiModelList = locationList.map { location ->
                            LocationUiModel(location.name)
                        },
                    )
                }
            }.onFailure {
                println(Thread.currentThread().name)
                _state.update {
                    it.copy(
                        isLoading = false,
                        isError = true,
                    )
                }
            }
        }
    }

    fun errorAction() {
        if (state.value.isError) initializeScreenData()
    }

    data class ViewState(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val locationUiModelList: List<LocationUiModel> = emptyList()
    )
}