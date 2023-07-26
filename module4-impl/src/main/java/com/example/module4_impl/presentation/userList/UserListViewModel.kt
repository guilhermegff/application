package com.example.module4_impl.presentation.userList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.module4_impl.core.usecase.GetUserList
import com.example.module4_impl.presentation.UserUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUserList: GetUserList,
) : ViewModel() {

    private val _state = MutableStateFlow(ViewState())

    val state: StateFlow<ViewState> = _state

    init {
        initializeScreenData()
    }

    private fun initializeScreenData() {
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
                getUserList()
            }.onSuccess { userList ->
                println("Success ${Thread.currentThread().name}")
                _state.update {
                    it.copy(
                        isLoading = false,
                        isError = false,
                        userListUiModel = userList,
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
        if(state.value.isError) initializeScreenData()
    }

    data class ViewState(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val userListUiModel: List<UserUiModel> = emptyList()
    )
}