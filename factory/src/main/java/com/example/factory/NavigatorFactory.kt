package com.example.factory

import com.example.factory_api.AbstractNavigatorFactory1
import com.example.factory_api.AbstractNavigatorFactory2
import com.example.module1_api.Module1Navigator
import com.example.module2_api.Module2Navigator
import com.example.module2_impl.Module2NavigatorImpl
import com.project.module1.Module1NavigatorImpl

class NavigatorFactory : AbstractNavigatorFactory1, AbstractNavigatorFactory2 {
    override fun nav1() : Module1Navigator = Module1NavigatorImpl()
    override fun nav2() : Module2Navigator = Module2NavigatorImpl()
}