package com.example.module3_impl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.module3_impl.presentation.Module3InitialScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class Module3Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Module3InitialScreen {

            }
        }
    }
}