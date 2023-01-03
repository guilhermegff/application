package com.project.application.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.application.core.usecase.GetUserDetail
import com.project.application.core.usecase.GetUserList
import com.project.application.presentation.model.UserUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class UserDetailViewModel @Inject constructor(
    private val getUserDetail: GetUserDetail,
    private val getUserList: GetUserList,
) : ViewModel() {

    private val _state = MutableStateFlow(ViewState())

    val state = _state

    init {
        getDetail("4685")
    }

    private fun getDetail(id: String) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true,
                )
            }
            runCatching {
                getUserList.invoke()
                getUserDetail.invoke(id)
            }.onSuccess { userDetail ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        userUiModel = userDetail,
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

    data class ViewState(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val userUiModel: UserUiModel = UserUiModel()
    )
}