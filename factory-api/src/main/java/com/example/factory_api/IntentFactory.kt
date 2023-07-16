package com.example.factory_api

import android.content.Context
import android.content.Intent

interface IntentFactory {
    fun createIntent(context: Context) : Intent
}