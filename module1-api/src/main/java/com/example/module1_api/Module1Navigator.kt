package com.example.module1_api

import android.content.Context
import android.content.Intent

interface Module1Navigator {
    fun provideIntent(context: Context): Intent
}