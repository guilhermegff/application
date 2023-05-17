package com.project.application.presentation

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.findNavController
import com.project.application.R

class MainFragment : Fragment(R.layout.main_fragment) {
    private val toUserFragment = MainFragmentDirections.actionInitialModuleToUserFragment()
    private val toModule1Action = MainFragmentDirections.actionInitialModuleToModule1()
    private val toModule2Action = MainFragmentDirections.actionInitialModuleToModule2()
    private val toModule3Action = MainFragmentDirections.actionInitialModuleToModule3()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = view.findNavController()
        with(view) {
            val button1: Button = findViewById<Button?>(R.id.button1).apply {
                setOnClickListener {
                    navController.navigate(toUserFragment)
                }
            }
            val button2: Button = findViewById<Button?>(R.id.button2).apply {
                setOnClickListener {
                    navController.navigate(toModule1Action)
                }
            }
            val button3: Button = findViewById<Button?>(R.id.button3).apply {
                val request = NavDeepLinkRequest.Builder
                    .fromUri("android-app://example.module2_impl.app/module_2_fragment_3".toUri())
                    .build()
                setOnClickListener {
                    navController.navigate(toModule2Action)
                }
            }

            val button4: Button = findViewById<Button?>(R.id.button4).apply {
                setOnClickListener {
                    navController.navigate(toModule3Action)
                }
            }
        }
    }
}