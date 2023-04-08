package com.example.module2_api

import android.content.Context
import android.content.Intent

interface Module2Navigator {
    fun provideIntent(context: Context): Intent
}