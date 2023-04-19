package com.example.module2_impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Module2ViewModel2 : ViewModel() {
    private val _data = MutableLiveData<String>("String")
    val data : LiveData<String> get() = _data

}