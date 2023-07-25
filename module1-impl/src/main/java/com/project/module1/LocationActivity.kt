package com.project.module1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.example.factory_api.Module2IntentFactory
import com.example.localdatasource_api.user.UserEntity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LocationActivity : ComponentActivity() {
    @Inject
    lateinit var intentFactory: Module2IntentFactory

    @Inject
    lateinit var something: UserEntity

    private val viewModel: LocationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            val viewState: LocationViewModel.ViewState = viewModel.state.collectAsState(
                initial =
                LocationViewModel.ViewState()
            ).value
            LocationScreen(
                viewState = viewState,
                retry = { viewModel.errorAction() },
                action = {
                    val intentProvider = intentFactory.provideModule2IntentFactory()
                    startActivity(intentProvider.createIntent(this))
                }
            )
        }
        println("String L: $something")
    }
}
