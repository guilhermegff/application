package com.project.application.presentation.userDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.application.core.usecase.GetUser
import com.project.application.presentation.model.UserUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
internal class UserDetailViewModel @Inject constructor(
    private val getUser: GetUser,
    private val dispatcher: CoroutineDispatcher,
) : ViewModel() {

    private val _state = MutableStateFlow(ViewState())
    val state: StateFlow<ViewState> = _state

    fun getDetail(id: String) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true,
                )
            }
            delay(1000)
            runCatching {
                withContext(dispatcher) {
                    getUser.invoke(
                        id
                            .removePrefix("{")
                            .removeSuffix("}")
                    )
                }
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