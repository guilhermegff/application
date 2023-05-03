package com.example.module2_impl

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
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
        /*registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {}.launch(Manifest.permission.POST_NOTIFICATIONS)*/
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler: RecyclerView = view.findViewById(R.id.recycler)

        val viewModel = ViewModelProvider(requireActivity())[Module2ViewModel3::class.java]

        val adapter = ItemAdapter {
        }.apply {
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

    @SuppressLint("MissingPermission")
    private fun sendNotification() {
        if (ContextCompat.checkSelfPermission(
                requireActivity(), Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            val builder = NotificationCompat.Builder(requireActivity(), "1")
                .setContentTitle("Test")
                .setContentText("a")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            NotificationManagerCompat.from(requireActivity())
                .notify(R.string.id, builder.build())
        }
    }
}