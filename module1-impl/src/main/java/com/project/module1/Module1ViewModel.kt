package com.project.module1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class Module1ViewModel @Inject constructor(
    private val module1Action: Module1Action,
) : ViewModel() {

    fun getDetail() {
        viewModelScope.launch {
            runCatching {
                module1Action.invoke()
            }.onSuccess {
                val a = it
            }.onFailure {
                val a = it
            }
        }
    }
}