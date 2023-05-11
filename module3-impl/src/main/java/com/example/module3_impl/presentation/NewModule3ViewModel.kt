package com.example.module3_impl.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class NewModule3ViewModel : ViewModel() {

    private val state = MutableStateFlow(ViewState())

    data class ViewState(
        val numbers: List<Module3Numbers> = emptyList<Module3Numbers>()
    )
}

data class Module3Numbers(
    val id: Int,
    val number: Int,
)