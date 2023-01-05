package com.project.application.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import com.project.application.presentation.userList.UserListScreen
import com.project.application.presentation.userList.UserListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: UserListViewModel by viewModels()

        setContent {
            val viewState = viewModel.state.collectAsState().value
            UserListScreen(
                viewState = viewState,
            )
        }
    }
}