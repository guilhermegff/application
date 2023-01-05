package com.project.application.presentation.userDetail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
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

@Composable
internal fun UserDetailScreen(
    viewState: UserDetailViewModel.ViewState,
    onBackClick: () -> Unit,
) {
    when {
        viewState.isLoading -> LoadingScreen()
        viewState.isError -> ErrorScreen(onBackClick)
        else -> ScreenContent(viewState)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun ScreenContent(
    viewState: UserDetailViewModel.ViewState,
) {
    Scaffold {
        Column(
            modifier = Modifier
                .padding(horizontal = Dp(32f))
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(top = Dp(30f))
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "id: ${viewState.userUiModel.id}",
                color = Color.Black,
            )
            Text(
                modifier = Modifier
                    .padding(top = Dp(30f))
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "name: ${viewState.userUiModel.name}",
                color = Color.Black,
            )
            Text(
                modifier = Modifier
                    .padding(top = Dp(30f))
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "email: ${viewState.userUiModel.email}",
                color = Color.Black,
            )
            Text(
                modifier = Modifier
                    .padding(top = Dp(30f))
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "gender: ${viewState.userUiModel.gender}",
                color = Color.Black,
            )
            Text(
                modifier = Modifier
                    .padding(top = Dp(30f))
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "status: ${viewState.userUiModel.status}",
                color = Color.Black,
            )
        }
    }
}

@Composable
@Preview
private fun PreviewScreen() {
    UserDetailScreen(
        viewState = UserDetailViewModel.ViewState(),
        onBackClick = {},
    )
}