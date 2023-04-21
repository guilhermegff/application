package com.example.module2_impl

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

class Module2ViewModel3 : ViewModel() {
     val _data = flow {
        for (number in 0..20) {
            delay(1000)
            Log.d("TAG", "Emitted: String $number")
            emit("$number")
        }
    }.onStart {
        Log.d("TAG", "Started")
    }.onCompletion {
        Log.d("TAG", "Completed")
    }
}