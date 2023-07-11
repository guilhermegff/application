package com.example.module2_impl

import androidx.lifecycle.*
import kotlin.random.Random

class Module2ViewModel : ViewModel() {
    private val _data = MutableLiveData<List<String>>()
    private val mappedData: LiveData<List<String>> = _data.map {
        it.map { string ->
            "$string Mapped"
        }
    }

    val data: LiveData<List<String>> get() = _data
    val mediatedData = MediatorLiveData<List<String>>()

    val otherTransformedData: LiveData<List<String>> = _data.switchMap {
        transformToLiveData(it)
    }

    init {
        mediatedData.addSource(_data) {
            mediatedData.value = transformToList(it)
        }
        mediatedData.addSource(mappedData) {
            Thread() {
                Thread.sleep(2000)
                mediatedData.postValue(transformToList(it))
            }.start()
        }
    }

    private fun transformToLiveData(strings: List<String>): LiveData<List<String>> =
        MutableLiveData(strings.map {
            "Transformed $it"
        })

    private fun transformToList(strings: List<String>): List<String> = strings.map {
        "Transformed $it"
    }

    fun changeData() {
        val limit = Random.nextInt(1, 6)
        _data.value = arrayListOf<String>().apply {
            for (number in 0..limit) {
                add("String $number")
            }
        }
    }
}