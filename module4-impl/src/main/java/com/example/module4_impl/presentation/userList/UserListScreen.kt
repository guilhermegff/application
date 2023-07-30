package com.example.module4_impl.presentation.userList

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.module4_impl.presentation.UserUiModel
import com.project.application.presentation.compose.ErrorScreen
import com.example.module4_impl.presentation.compose.LoadingScreen

@Composable
fun UserListScreen(
    viewState: UserListViewModel.ViewState,
    action: () -> Unit,
    onClick: (id: String) -> Unit,
) {
    when {
        viewState.isLoading -> LoadingScreen()
        viewState.isError -> ErrorScreen(action)
        else -> ScreenContent(
            viewState,
            onClick,
        )
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenContent(
    viewState: UserListViewModel.ViewState,
    onClick: (id: String) -> Unit,
) {
    Scaffold {
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = Dp(32f))
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(viewState.userListUiModel) {
                UserRow(
                    it,
                    onClick,
                )
            }
        }
    }
}

@Composable
fun UserRow(
    userUiModel: UserUiModel,
    onClick: (id: String) -> Unit,
) {
    Row(
        modifier = Modifier.clickable {
            onClick.invoke(userUiModel.id.toString())
        }
    ) {
        Column() {
            Text(
                modifier = Modifier
                    .padding(top = Dp(30f))
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "name: ${userUiModel.name}",
                color = Color.Black,
            )
            Text(
                modifier = Modifier
                    .padding(top = Dp(30f))
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "status: ${userUiModel.status}",
                color = Color.Black,
            )
        }
    }
}

@Preview
@Composable
private fun PreviewScreen() {
    UserListScreen(
        UserListViewModel.ViewState(
            userListUiModel = listOf(
                UserUiModel(name = "A", status = "1"),
                UserUiModel(name = "B", status = "2"),
                UserUiModel(name = "C", status = "3"),
                UserUiModel(name = "D", status = "4"),
            )
        ),
        {},
        {}
    )
}