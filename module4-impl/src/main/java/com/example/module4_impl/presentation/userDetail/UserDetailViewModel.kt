package com.example.module4_impl.presentation.userDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.module4_impl.core.usecase.GetUserUseCase
import com.example.module4_impl.core.usecase.GetUserUseCaseResult
import com.example.module4_impl.presentation.UserUiModel
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
    private val getUserUseCase: GetUserUseCase,
    private val dispatcher: CoroutineDispatcher,
) : ViewModel() {

    private val _state = MutableStateFlow(ViewState())
    val state: StateFlow<ViewState> = _state

    fun getDetail(id: String) {
        viewModelScope.launch {
            showLoading()
            delay(1000)
            withContext(dispatcher) {
                val cleanId = id
                    .removePrefix("{")
                    .removeSuffix("}")
                when(getUserUseCase(cleanId)) {
                    is GetUserUseCaseResult.Error -> showError()
                    is GetUserUseCaseResult.Success -> showSuccess()
                    is GetUserUseCaseResult.SuccessWithNoId -> showSuccessWithWarning()
                }
            }
        }
    }

    private fun showLoading() {
        _state.update {
            it.copy(
                isLoading = true,
            )
        }
    }

    private fun showError() {
        _state.update {
            it.copy(
                isLoading = false,
                isError = true,
            )
        }
    }

    private fun showSuccess() {
        _state.update {
            it.copy(
                isLoading = false,
                userUiModel = it.userUiModel,
            )
        }
    }

    private fun showSuccessWithWarning() {
        _state.update {
            it.copy(
                isLoading = false,
                showWarning = true,
                userUiModel = it.userUiModel,
            )
        }
    }

    data class ViewState(
        val isLoading: Boolean = false,
        val isError: Boolean = false,
        val showWarning: Boolean = false,
        val userUiModel: UserUiModel = UserUiModel()
    )
}