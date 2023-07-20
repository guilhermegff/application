package com.example.factory

import com.example.module2_impl.Module2IntentFactoryImpl
import com.project.module1.Module1IntentFactoryImpl
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.instanceOf
import org.junit.Test

class IntentFactoriesTest {
    private val intentFactories = IntentFactories()

    @Test
    fun `intentFactories provides correct module1 intentFactory`() {
        val result = intentFactories.provideModule1IntentFactory()
        assertThat(result, instanceOf(Module1IntentFactoryImpl::class.java))
    }

    @Test
    fun `intentFactories provides correct module2 intentFactory`() {
        val result = intentFactories.provideModule2IntentFactory()
        assertThat(result, instanceOf(Module2IntentFactoryImpl::class.java))
    }
}