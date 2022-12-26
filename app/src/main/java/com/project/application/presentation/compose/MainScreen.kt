package com.project.application

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.project.application.presentation.MainViewModel
import com.project.application.presentation.compose.LoadingScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun MainScreen(
    viewState: MainViewModel.ViewState,
    action: () -> Unit,
) {
    when {
        viewState.isLoading -> LoadingScreen()
        else -> ScreenContent(action)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun ScreenContent(
    action: () -> Unit,
) {
    Scaffold {
        Column(
            modifier = Modifier
                .padding(horizontal = Dp(32f))
        ) {
            Text(
                modifier = Modifier
                    .padding(top = Dp(30f))
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "Main Screen",
                color = Color.Black,
            )
            Button(
                content = { Text(text = "Button") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = Dp(10f)),
                onClick = { action.invoke() }
            )
        }
    }
}

@Composable
@Preview
internal fun PreviewScreen() {
    MainScreen(viewState = MainViewModel.ViewState()) {}
}