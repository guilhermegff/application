package com.example.module2_impl

import android.content.Context
import android.content.Intent
import com.example.module2_api.Module2Navigator

class Module2NavigatorImpl : Module2Navigator {
    override fun provideIntent(context: Context) = Intent(context, MainActivity::class.java)
}