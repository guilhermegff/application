package com.example.module3_impl.presentation.compose

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
import com.example.module3_impl.Module3ViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Module3InitialScreen(
    action: () -> Unit,
) {
    val viewModel: Module3ViewModel = hiltViewModel()
    Scaffold() {
        Column(
            modifier = Modifier.padding(top = Dp(40f))
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "Module 3 Initial Screen",
                color = Color.Black,
            )
            Button(
                content = { Text(text = "Next")},
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
    Module3InitialScreen() {}
}