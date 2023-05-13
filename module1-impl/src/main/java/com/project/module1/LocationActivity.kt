package com.project.module1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.factory_api.AbstractNavigatorFactory2
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LocationActivity : ComponentActivity() {
    @Inject
    lateinit var navigatorFactory: AbstractNavigatorFactory2

    private val viewModel: LocationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LocationScreen(
                viewModel = viewModel,
                retry = { viewModel.errorAction() },
                action = {
                    val intentProvider = navigatorFactory.nav2()
                    startActivity(intentProvider.provideIntent(this))
                }
            )
        }
    }
}
