package com.example.datasource

import com.example.localdatasource_api.user.UserDaoContract
import com.example.localdatasource_api.user.UserDataStoreDaoContract
import com.example.localdatasource_api.user.UserEntity
import com.example.localdatasource_api.user.UserSharedPreferencesDaoContract
import com.example.datasource_impl.user.UserDbMapperImpl
import com.example.datasource_impl.user.UserLocalDao
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.mockito.Mockito.*

class UserLocalDaoTest : UserLocalDaoTestFixture {
    @Suppress("UNCHECKED_CAST")
    private val userDaoContract = mock(UserDaoContract::class.java).apply {
        `when`(this.getAll()).thenReturn(expectedList)
        `when`(this.loadAllByIds(ids)).thenReturn(expectedList)
        `when`(this.findByName(userDataModel.name)).thenReturn(userDataModel)
    } as UserDaoContract<UserEntity>

    private val userSharedPreferencesDaoContract =
        mock(UserSharedPreferencesDaoContract::class.java)
    private val userDataStoreDaoContract = mock(UserDataStoreDaoContract::class.java)
    private val userDbMapper = UserDbMapperImpl.newInstance()

    private val userLocalDao = UserLocalDao(
        userDaoContract,
        userDbMapper,
        userSharedPreferencesDaoContract,
        userDataStoreDaoContract,
    )

    @Test
    fun `userLocalDao returns expected list when getAll is called`() {
        val result = userLocalDao.getAll()
        assertThat(result, equalTo(expectedList))
    }

    @Test
    fun `userDaoContract getAll is called once when userLocalDao calls getAll`() {
        userLocalDao.getAll()
        verify(userDaoContract, times(1)).getAll()
    }

    @Test
    fun `userLocalDao returns expected list when loadAllByIds is called`() {
        val result = userLocalDao.loadAllByIds(ids)
        assertThat(result, equalTo(expectedList))
    }

    @Test
    fun `userDaoContract loadAllByIds is called once when userLocalDao calls loadAllByIds`() {
        userLocalDao.loadAllByIds(ids)
        verify(userDaoContract, times(1)).loadAllByIds(ids)
    }

    @Test
    fun `userLocalDao returns expected object when findByName is called`() {
        val result = userLocalDao.findByName(userDataModel.name)
        assertThat(result, equalTo(userDataModel))
    }

    @Test
    fun `userDaoContract findByName is called once when userLocalDao calls findByName`() {
        userLocalDao.findByName(userDataModel.name)
        verify(userDaoContract, times(1)).findByName(userDataModel.name)
    }

    @Test
    fun `userDaoContract insertAll is called once when userLocalDao calls insertAll`() {
        userLocalDao.insertAll(userDataModel)
        verify(userDaoContract, times(1)).insertAll(userDataBaseModel)
    }

    @Test
    fun `userDaoContract delete is called once when userLocalDao call delete`() {
        userLocalDao.delete(userDataModel)
        verify(userDaoContract, times(1)).delete(userDataBaseModel)
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