package com.project.module1

import android.content.Context
import android.content.Intent
import com.example.factory_api.IntentFactory

class Module1IntentFactoryImpl : IntentFactory {
    override fun createIntent(context: Context) = Intent(context, LocationActivity::class.java)
}