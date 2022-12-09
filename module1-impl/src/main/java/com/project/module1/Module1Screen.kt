package com.project.module1

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Module1Screen(
    viewModel: Module1ViewModel,
) {
    Scaffold() {
        Text(
            text = "Module1 Screen",
            color = Color.Black,
        )
    }
}