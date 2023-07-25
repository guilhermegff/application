package com.project.application.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.localdatasource_api.user.UserEntity
import com.project.application.R.layout
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
internal class MainActivity () : AppCompatActivity() {
    @Inject
    lateinit var something: UserEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("String M: $something")
        setContentView(layout.main_activity)
    }
}