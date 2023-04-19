package com.project.application.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.module1_api.Module1Navigator
import com.example.module2_api.Module2Navigator
import com.project.application.presentation.compose.UserNavigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
internal class MainActivity () : ComponentActivity() {

    @Inject
    lateinit var module1Navigator: Module1Navigator
    @Inject
    lateinit var module2Navigator: Module2Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserNavigation(
                navigateToModule1 = { startModule1() },
                navigateToModule2 = { startModule2() }
            )
        }
    }

    private fun startModule1() {
        startActivity(module1Navigator.provideIntent(this))
    }

    private fun startModule2() {
        startActivity(module2Navigator.provideIntent(this))
    }
}