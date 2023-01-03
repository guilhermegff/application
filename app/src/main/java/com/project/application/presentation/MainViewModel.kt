package com.project.application.presentation

import androidx.lifecycle.ViewModel
import com.project.application.core.usecase.GetUserDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserDetail: GetUserDetail,
) : ViewModel() {

    private val _state = MutableStateFlow(ViewState())

    val state = _state

    data class ViewState(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
    )
}