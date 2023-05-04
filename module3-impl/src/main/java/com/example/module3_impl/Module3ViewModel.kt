package com.example.module3_impl

import androidx.lifecycle.ViewModel
import com.example.module3_impl.presentation.model.Module3UiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
internal class Module3ViewModel @Inject constructor(

) : ViewModel() {
    private val _state = MutableStateFlow(ViewState())
    val state: StateFlow<ViewState> = _state

    internal data class ViewState(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val module3UiModel: Module3UiModel = Module3UiModel()
    )
}