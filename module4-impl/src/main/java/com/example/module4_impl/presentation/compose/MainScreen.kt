package com.example.module4_impl.presentation.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun MainScreen(
    action1: () -> Unit,
    action2: () -> Unit,
    action3: () -> Unit,
) {
    ScreenContent(
        action1,
        action2,
        action3,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun ScreenContent(
    action1: () -> Unit,
    action2: () -> Unit,
    action3: () -> Unit,
) {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Dp(32f)),
            verticalArrangement = Arrangement.Center
        ) {
            ItemRow(
                action1,
                "Go to same Module",
            )
            ItemRow(
                action2,
                "Go to Module 1",
            )
            ItemRow(
                action3,
                "Go to Module 2",
            )
        }
    }
}

@Composable
private fun ItemRow(
    action: () -> Unit,
    text: String,
) {
    Row() {
        Button(
            content = { Text(text = text) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Dp(10f)),
            onClick = { action.invoke() }
        )
    }
}

@Composable
@Preview
private fun PreviewScreen() {
    MainScreen(
        action1 = {},
        action2 = {},
        action3 = {},
    )
}