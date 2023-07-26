package com.project.application.presentation.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.module4_impl.R

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
                Text(text = stringResource(id = R.string.error_message_try_again))
                Button(
                    modifier = Modifier.padding(top = Dp(32f)),
                    content = {
                        Text(
                            color = Color.White,
                            text = stringResource(id = R.string.retry_button),
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

@Preview
@Composable
private fun PreviewScreen() {
    ErrorScreen {}
}