package com.project.application.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.project.application.presentation.compose.UserNavigation
import com.project.module1.Module1Activity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class MainActivity : ComponentActivity() {
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
        val intent = Intent(this, Module1Activity::class.java)
        startActivity(intent)
    }
}