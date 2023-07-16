package com.example.module2_impl

import android.content.Context
import android.content.Intent
import com.example.factory_api.IntentFactory

class Module2IntentFactoryImpl : IntentFactory {
    override fun createIntent(context: Context) = Intent(context, MainActivity::class.java)
}