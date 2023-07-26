package com.example.datasource_impl

import com.example.datasource_api.user.UserDataBaseDaoContract
import com.example.datasource_api.user.UserDataStoreDaoContract
import com.example.datasource_api.user.UserEntity
import com.example.datasource_api.user.UserSharedPreferencesDaoContract
import com.example.datasource_impl.user.UserDbMapperImpl
import com.example.datasource_impl.user.UserDao
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.mockito.Mockito.*

class UserDaoTest : UserLocalDaoTestFixture {
    @Suppress("UNCHECKED_CAST")
    private val userDataBaseDaoContract = mock(UserDataBaseDaoContract::class.java).apply {
        `when`(this.getAll()).thenReturn(expectedList)
        `when`(this.loadAllByIds(ids)).thenReturn(expectedList)
        `when`(this.findByName(userDataModel.name)).thenReturn(userDataModel)
    } as UserDataBaseDaoContract<UserEntity>

    private val userSharedPreferencesDaoContract =
        mock(UserSharedPreferencesDaoContract::class.java)
    private val userDataStoreDaoContract = mock(UserDataStoreDaoContract::class.java)
    private val userDbMapper = UserDbMapperImpl.newInstance()

    private val userDao = UserDao(
        userDataBaseDaoContract,
        userDbMapper,
        userSharedPreferencesDaoContract,
        userDataStoreDaoContract,
    )

    @Test
    fun `userLocalDao returns expected list when getAll is called`() {
        val result = userDao.getAll()
        assertThat(result, equalTo(expectedList))
    }

    @Test
    fun `userDaoContract getAll is called once when userLocalDao calls getAll`() {
        userDao.getAll()
        verify(userDataBaseDaoContract, times(1)).getAll()
    }

    @Test
    fun `userLocalDao returns expected list when loadAllByIds is called`() {
        val result = userDao.loadAllByIds(ids)
        assertThat(result, equalTo(expectedList))
    }

    @Test
    fun `userDaoContract loadAllByIds is called once when userLocalDao calls loadAllByIds`() {
        userDao.loadAllByIds(ids)
        verify(userDataBaseDaoContract, times(1)).loadAllByIds(ids)
    }

    @Test
    fun `userLocalDao returns expected object when findByName is called`() {
        val result = userDao.findByName(userDataModel.name)
        assertThat(result, equalTo(userDataModel))
    }

    @Test
    fun `userDaoContract findByName is called once when userLocalDao calls findByName`() {
        userDao.findByName(userDataModel.name)
        verify(userDataBaseDaoContract, times(1)).findByName(userDataModel.name)
    }

    @Test
    fun `userDaoContract insertAll is called once when userLocalDao calls insertAll`() {
        userDao.insertAll(userDataModel)
        verify(userDataBaseDaoContract, times(1)).insertAll(userDataBaseModel)
    }

    @Test
    fun `userDaoContract delete is called once when userLocalDao call delete`() {
        userDao.delete(userDataModel)
        verify(userDataBaseDaoContract, times(1)).delete(userDataBaseModel)
    }

    @Test
    fun `userSharedPreferencesDaoContract saveToken is called once when userLocalDao calls saveToken`() {
        userSharedPreferencesDaoContract.saveToken(token)
        verify(userSharedPreferencesDaoContract, times(1)).saveToken(token)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `userDataStoreDaoContract saveId is called once when userLocalDao calls saveId`() =
        runTest {
            userDataStoreDaoContract.saveId(ids.first().toString())
            verify(userDataStoreDaoContract, times(1)).saveId(ids.first().toString())
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `userDataStoreDaoContract getId is called once when userLocalDao calls getId`() = runTest {
        userDataStoreDaoContract.getId()
        verify(userDataStoreDaoContract, times(1)).getId()
    }
}