package com.project.module1

import android.content.Context
import android.content.Intent
import com.example.module1_api.Module1Navigator

class Module1NavigatorImpl : Module1Navigator {
    override fun provideIntent(context: Context) = Intent(context, Module1Activity::class.java)
}