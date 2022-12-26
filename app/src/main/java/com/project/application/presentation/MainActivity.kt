package com.project.application.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import com.project.application.presentation.compose.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels()

        setContent {
            val viewState = viewModel.state.collectAsState().value
            MainScreen(
                viewState = viewState,
                onBackClick = { super.onBackPressed() },
                action = { viewModel.getDetail() },
            )
        }
    }
}