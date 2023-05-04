package com.project.module1

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
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun LocationScreen(
    action: () -> Unit,
) {
    Scaffold(
    ) {
        Column(
            modifier = Modifier.padding(top = Dp(40f))
        ) {
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
        }
    }
}

@Composable
@Preview
internal fun PreviewScreen() {
    LocationScreen() {}
}