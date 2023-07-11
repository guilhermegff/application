package com.example.module2_impl

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.project.module2.R
import kotlinx.coroutines.launch

class Module2Fragment3 : Fragment(R.layout.fragment_main_3) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler: RecyclerView = view.findViewById(R.id.recycler)

        val viewModel = ViewModelProvider(requireActivity())[Module2ViewModel3::class.java]

        val adapter = ItemAdapter {}.apply {
            bindData(
                listOf(
                    "String One",
                    "String Two",
                )
            )
        }
        with(viewLifecycleOwner) {
            lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    val a = arrayListOf<String>()
                    viewModel._data.collect {
                        a.add(it)
                        Log.d("TAG", "Collected: String $it")
                        adapter.bindData(a)
                    }
                }
            }
        }
        recycler.adapter = adapter
    }
}