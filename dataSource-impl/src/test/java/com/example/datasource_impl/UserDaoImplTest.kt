package com.example.datasource_impl

import com.example.datasource_api.user.*
import com.example.datasource_impl.user.UserDbMapperImpl
import com.example.datasource_impl.user.UserDaoImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.mockito.Mockito.*

class UserDaoImplTest : UserLocalDaoTestFixture {
    @Suppress("UNCHECKED_CAST")
    private val userDataBaseDao = mock(UserDataBaseDao::class.java).apply {
        `when`(this.getAll()).thenReturn(expectedList)
        `when`(this.loadAllByIds(ids)).thenReturn(expectedList)
        `when`(this.findByName(userDataModel.name)).thenReturn(userDataModel)
    } as UserDataBaseDao<UserEntity>

    private val userRemoteDao = mock(UserRemoteDao::class.java)

    private val userSharedPreferencesDao =
        mock(UserSharedPreferencesDao::class.java)
    private val userDataStoreDao = mock(UserDataStoreDao::class.java)
    private val userDbMapper = UserDbMapperImpl.newInstance()

    private val userDao = UserDaoImpl(
        userDataBaseDao,
        userDbMapper,
        userSharedPreferencesDao,
        userDataStoreDao,
        userRemoteDao,
    )

    @Test
    fun `userLocalDao returns expected list when getAll is called`() {
        val result = userDao.getAll()
        assertThat(result, equalTo(expectedList))
    }

    @Test
    fun `userDaoContract getAll is called once when userLocalDao calls getAll`() {
        userDao.getAll()
        verify(userDataBaseDao, times(1)).getAll()
    }

    @Test
    fun `userLocalDao returns expected list when loadAllByIds is called`() {
        val result = userDao.loadAllByIds(ids)
        assertThat(result, equalTo(expectedList))
    }

    @Test
    fun `userDaoContract loadAllByIds is called once when userLocalDao calls loadAllByIds`() {
        userDao.loadAllByIds(ids)
        verify(userDataBaseDao, times(1)).loadAllByIds(ids)
    }

    @Test
    fun `userLocalDao returns expected object when findByName is called`() {
        val result = userDao.findByName(userDataModel.name)
        assertThat(result, equalTo(userDataModel))
    }

    @Test
    fun `userDaoContract findByName is called once when userLocalDao calls findByName`() {
        userDao.findByName(userDataModel.name)
        verify(userDataBaseDao, times(1)).findByName(userDataModel.name)
    }

    @Test
    fun `userDaoContract insertAll is called once when userLocalDao calls insertAll`() {
        userDao.insertAll(userDataModel)
        verify(userDataBaseDao, times(1)).insertAll(userDataBaseModel)
    }

    @Test
    fun `userDaoContract delete is called once when userLocalDao call delete`() {
        userDao.delete(userDataModel)
        verify(userDataBaseDao, times(1)).delete(userDataBaseModel)
    }

    @Test
    fun `userSharedPreferencesDaoContract saveToken is called once when userLocalDao calls saveToken`() {
        userSharedPreferencesDao.saveToken(token)
        verify(userSharedPreferencesDao, times(1)).saveToken(token)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `userDataStoreDaoContract saveId is called once when userLocalDao calls saveId`() =
        runTest {
            userDataStoreDao.saveId(ids.first().toString())
            verify(userDataStoreDao, times(1)).saveId(ids.first().toString())
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `userDataStoreDaoContract getId is called once when userLocalDao calls getId`() = runTest {
        userDataStoreDao.getId()
        verify(userDataStoreDao, times(1)).getId()
    }
}