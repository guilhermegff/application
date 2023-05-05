package com.example.module3_impl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.module3_impl.presentation.compose.Module3InitialScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Module3Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireActivity()).apply {
            setContent {
                Module3InitialScreen() {

                }
            }
        }
    }
}