package com.project.module1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.module1.core.usecase.GetLocationList
import com.project.module1.presentation.LocationUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
internal class LocationViewModel @Inject constructor(
    private val getLocationList: GetLocationList,
    private val dispatcher: CoroutineDispatcher,
) : ViewModel() {

    private val _state = MutableSharedFlow<ViewState>(replay = 10)
    val state: SharedFlow<ViewState> = _state

    init {
        initializeScreenData()
    }

    private fun initializeScreenData() {
        println("Before Launch ${Thread.currentThread().name}")
        viewModelScope.launch {
            println("On Launch ${Thread.currentThread().name}")
            _state.emit(ViewState(isLoading = true))
            runCatching {
                println("Run ${Thread.currentThread().name}")
                withContext(dispatcher) {
                    println("Context ${Thread.currentThread().name}")
                    getLocationList()
                }
            }.onSuccess { locationList ->
                println("Success ${Thread.currentThread().name}")
                _state.emit(
                    ViewState(
                        isLoading = false,
                        isError = false,
                        locationUiModelList = locationList.map { location ->
                            LocationUiModel(location.name)
                        },
                    )
                )
            }.onFailure {
                println(Thread.currentThread().name)
                _state.emit(
                    ViewState(
                        isLoading = false,
                        isError = true,
                    )
                )
            }
        }
    }

    fun errorAction() {
        initializeScreenData()
    }

    data class ViewState(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val locationUiModelList: List<LocationUiModel> = emptyList()
    )
}