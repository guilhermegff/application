package com.example.module3_impl.presentation.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.module3_impl.presentation.Module3Numbers
import com.example.module3_impl.presentation.NewModule3ViewModel
import kotlin.random.Random

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun Module3SecondScreen(
    viewState: NewModule3ViewModel.ViewState,
    action: () -> Unit,
) {
    ScreenContent(viewState)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ScreenContent(
    viewState: NewModule3ViewModel.ViewState,
) {
    Scaffold {
        Text(
            modifier = Modifier
                .padding(top = Dp(40f))
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.Black,
            text = "Module3SecondScreen",
        )
    }
}

@Preview
@Composable
private fun PreviewModule3Screen() {
    Module3SecondScreen(
        NewModule3ViewModel.ViewState(
            numbers = listOf(
                Module3Numbers(id = 0, number = Random.nextInt(0, 100)),
                Module3Numbers(id = 1, number = Random.nextInt(0, 100)),
                Module3Numbers(id = 1, number = Random.nextInt(0, 100))
            )
        )
    ) {}
}