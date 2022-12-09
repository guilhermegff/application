package com.project.module1

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Module1ViewModel @Inject constructor(
    private val mainAction: Module1Action,
) : ViewModel() {

}