package com.example.datasource_impl

import com.example.datasource_api.user.UserDbMapper
import com.example.datasource_impl.user.UserDbMapperImpl
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Test

class UserDbMapperImplTest : UserDbMapperTestFixture {
    private val userDbMapperImplTest = UserDbMapperImpl.newInstance()

    @Test
    fun `mapper implements the expected contract`() {
        assertThat(userDbMapperImplTest, instanceOf(UserDbMapper::class.java))
    }

    @Test
    fun `mapper transforms UserEntity to UserDataBaseModel model`() {
        val result = userDbMapperImplTest.transform(userDataModel)
        assertThat(result, equalTo(userDataBaseModel))
    }
}