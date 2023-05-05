package com.example.module3_impl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.module3_impl.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class Module3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module_3)
    }
}