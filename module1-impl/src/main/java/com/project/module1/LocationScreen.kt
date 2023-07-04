package com.project.module1

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.project.module1.presentation.LocationUiModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun LocationScreen(
    viewState: LocationViewModel.ViewState,
    action: () -> Unit,
    retry: () -> Unit,
) {

    when {
        viewState.isLoading -> LoadingScreen()
        viewState.isError -> ErrorScreen(retry)
        else -> ScreenContent(
            viewState,
            action
        )
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ScreenContent(
    viewState: LocationViewModel.ViewState,
    action: () -> Unit,
) {
    Scaffold {
        Column {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "Module1 Screen",
                color = Color.Black,
            )
            Button(
                content = { Text(text = "Button") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = Dp(10f)),
                onClick = {
                    action.invoke()
                }
            )
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = Dp(32f))
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                items(viewState.locationUiModelList) {
                    UserRow(
                        it,
                    )
                }
            }
        }
    }
}

@Composable
fun UserRow(
    userUiModel: LocationUiModel,
) {
    Row(
        modifier = Modifier.clickable {
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
                text = "status:",
                color = Color.Black,
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun LoadingScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(
            color = Color.Green,
            strokeWidth = Dp(4f)
        )
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ErrorScreen(
    action: () -> Unit,
) {
    Scaffold(
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Error")
                Button(
                    modifier = Modifier.padding(top = Dp(32f)),
                    content = {
                        Text(
                            color = Color.White,
                            text = "Try Again",
                        )
                    },
                    onClick = {
                        action.invoke()
                    },
                )
            }
        }
    }
}

/*
@Composable
@Preview
internal fun PreviewScreen() {
    LocationScreen(
        LocationViewModel.ViewState()
    ) {}
}*/
