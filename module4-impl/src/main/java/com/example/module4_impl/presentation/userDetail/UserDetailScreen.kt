package com.example.module4_impl.presentation.userDetail

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.module4_impl.R
import com.project.application.presentation.compose.ErrorScreen
import com.example.module4_impl.presentation.compose.LoadingScreen

@Composable
internal fun UserDetailScreen(
    viewState: UserDetailViewModel.ViewState,
    action: () -> Unit,
    onClick: () -> Unit,
    onBackClick: () -> Unit,
) {

    LaunchedEffect(key1 = Unit) {
        action.invoke()
    }

    when {
        viewState.isLoading -> LoadingScreen()
        viewState.isError -> ErrorScreen(onBackClick)
        else -> ScreenContent(viewState, onClick)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun ScreenContent(
    viewState: UserDetailViewModel.ViewState,
    onClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "") },
                navigationIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "Back button",
                        modifier = Modifier
                            .padding(Dp(10f))
                            .clickable {
                            }
                    )
                }
            )
        }
    ) {

        Column(
            modifier = Modifier
                .padding(horizontal = Dp(32f))
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                modifier = Modifier
                    .background(Color.Blue),
                onClick = {
                    onClick.invoke()
                }
            ) {
                Text(text = "Button")
            }

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
        action = {},
        onClick = {},
        onBackClick = {},
    )
}