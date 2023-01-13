package com.project.application.presentation.userList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.application.core.usecase.GetUserList
import com.project.application.presentation.model.UserUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUserList: GetUserList,
) : ViewModel() {

    private val _state = MutableStateFlow(ViewState())

    val state = _state

    init {
        initializeScreenData()
    }

    private fun initializeScreenData() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true,
                )
            }
            runCatching {
                getUserList()
            }.onSuccess { userList ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        isError = false,
                        userListUiModel = userList,
                    )
                }
            }.onFailure {
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