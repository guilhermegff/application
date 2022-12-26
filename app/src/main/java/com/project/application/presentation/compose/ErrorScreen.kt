package com.project.application.presentation.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.project.application.R.drawable.ic_arrow_back

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ErrorScreen(
    onClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "") },
                navigationIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = ic_arrow_back),
                        contentDescription = "Back button",
                        modifier = Modifier.clickable {
                            onClick.invoke()
                        }
                    )
                }
            )
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                content = {
                    Text(
                        color = Color.White,
                        text = "Retry",
                    )
                },
                onClick = {},
            )
        }
    }
}

@Preview
@Composable
private fun PreviewScreen() {
    ErrorScreen {}
}