package com.project.application.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.module1_api.Module1Navigator
import com.project.application.presentation.compose.UserNavigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
internal class MainActivity () : ComponentActivity() {

    @Inject
    lateinit var module1Navigator: Module1Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserNavigation(
                this,
            ) {
                callOtherModule()
            }
        }
    }

    private fun callOtherModule() {
        startActivity(module1Navigator.provideIntent(this))
    }
}