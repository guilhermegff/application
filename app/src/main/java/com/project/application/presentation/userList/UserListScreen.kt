package com.project.application.presentation.userList

import android.annotation.SuppressLint
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
import com.project.application.presentation.compose.ErrorScreen
import com.project.application.presentation.compose.LoadingScreen
import com.project.application.presentation.model.UserUiModel

@Composable
fun UserListScreen(
    viewState: UserListViewModel.ViewState,
    action: () -> Unit,
) {
    when {
        viewState.isLoading -> LoadingScreen()
        viewState.isError -> ErrorScreen(action)
        else -> ScreenContent(viewState)
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenContent(
    viewState: UserListViewModel.ViewState,
) {
    Scaffold {
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = Dp(32f))
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(viewState.userListUiModel) {
                UserRow(it)
            }
        }
    }
}

@Composable
fun UserRow(
    userUiModel: UserUiModel,
) {
    Row() {
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
    ) {}
}