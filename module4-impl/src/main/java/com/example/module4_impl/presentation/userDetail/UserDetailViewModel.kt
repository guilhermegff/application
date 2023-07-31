package com.example.module4_impl.presentation.userDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.datasource_api.user.UserEntity
import com.example.module4_impl.core.usecase.GetUserUseCase
import com.example.module4_impl.core.usecase.GetUserUseCaseResult
import com.example.module4_impl.presentation.UserUiMapper
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
    private val userUiMapper: UserUiMapper<UserUiModel>,
    private val dispatcher: CoroutineDispatcher,
) : ViewModel() {

    private val _state = MutableStateFlow(ViewState())
    val state: StateFlow<ViewState> = _state

    fun getDetail(id: String) {
        viewModelScope.launch {
            setLoading()
            delay(1000)
            withContext(dispatcher) {
                when (val result = getUserUseCase(trim(id))) {
                    is GetUserUseCaseResult.Error -> setError()
                    is GetUserUseCaseResult.Success -> setSuccess(result.obj)
                    is GetUserUseCaseResult.SuccessWithNoId -> setSuccessWithWarning(result.obj)
                }
            }
        }
    }

    private fun trim(id: String) = id.removePrefix("{").removeSuffix("}")

    private fun setLoading() {
        _state.update {
            it.copy(
                isLoading = true,
            )
        }
    }

    private fun setError() {
        _state.update {
            it.copy(
                isLoading = false,
                isError = true,
            )
        }
    }

    private fun setSuccess(userEntity: UserEntity) {
        _state.update {
            it.copy(
                isLoading = false,
                userUiModel = userUiMapper.transform(userEntity),
            )
        }
    }

    private fun setSuccessWithWarning(userEntity: UserEntity) {
        _state.update {
            it.copy(
                isLoading = false,
                showWarning = true,
                userUiModel = userUiMapper.transform(userEntity),
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