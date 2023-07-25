package com.project.application.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.application.R.layout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class MainActivity () : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.main_activity)
    }
}