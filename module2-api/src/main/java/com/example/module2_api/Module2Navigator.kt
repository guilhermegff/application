package com.example.module2_api

import android.content.Context
import android.content.Intent
import com.example.factory_api.ModuleNavigator

interface Module2Navigator : ModuleNavigator {
    override fun provideIntent(context: Context): Intent
}