package com.example.factory

import com.example.factory_api.IntentFactory
import com.example.factory_api.Module1IntentFactory
import com.example.factory_api.Module2IntentFactory
import com.example.module2_impl.Module2IntentFactoryImpl
import com.project.module1.Module1IntentFactoryImpl

class IntentFactories : Module1IntentFactory, Module2IntentFactory {
    override fun provideModule1IntentFactory() : IntentFactory = Module1IntentFactoryImpl()
    override fun provideModule2IntentFactory() : IntentFactory = Module2IntentFactoryImpl()
}