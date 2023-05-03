package com.example.module1_api

import android.content.Context
import android.content.Intent
import com.example.factory_api.ModuleNavigator

interface Module1Navigator : ModuleNavigator {
    override fun provideIntent(context: Context): Intent
}