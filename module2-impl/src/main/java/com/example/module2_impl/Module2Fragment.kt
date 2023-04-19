package com.example.module2_impl

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.project.module2.R

class Module2Fragment : Fragment(R.layout.fragment_main) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler: RecyclerView = view.findViewById(R.id.recycler)

        val viewModel = ViewModelProvider(requireActivity())[Module2ViewModel::class.java]

        val adapter = ItemAdapter {
            viewModel.changeData()
        }.apply {
            bindData(
                listOf(
                    "String One",
                    "String Two",
                )
            )
        }

        viewModel.mediatedData.observe(viewLifecycleOwner) { newData ->
            adapter.bindData(newData)
        }

        recycler.adapter = adapter
    }
}