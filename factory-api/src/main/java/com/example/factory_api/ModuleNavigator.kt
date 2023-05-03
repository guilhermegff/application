package com.example.factory_api

import android.content.Context
import android.content.Intent

interface ModuleNavigator {
    fun provideIntent(context: Context) : Intent
}