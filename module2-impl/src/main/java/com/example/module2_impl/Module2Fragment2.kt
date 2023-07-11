package com.example.module2_impl

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.project.module2.R

class Module2Fragment2 : Fragment(R.layout.fragment_main_2) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity())[Module2ViewModel2::class.java]

        val textField: TextView = view.findViewById(R.id.txt_name)
        viewModel.data.observe(viewLifecycleOwner) {
            textField.text = it
        }

    }
}