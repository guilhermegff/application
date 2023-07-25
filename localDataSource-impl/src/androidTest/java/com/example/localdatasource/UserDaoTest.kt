package com.example.localdatasource

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import com.example.localdatasource_api.user.UserDaoContract
import com.example.localdatasource_api.user.UserEntity
import com.example.localdatasource_impl.AppDatabase
import com.example.localdatasource_impl.user.UserDataBaseModel
import org.hamcrest.Matchers.equalTo
import org.junit.After
import org.junit.Before
import org.junit.Test

class UserDaoTest {

    private lateinit var db: AppDatabase
    private lateinit var userDao: UserDaoContract<UserEntity>
    private val modelList = arrayListOf<UserDataBaseModel>()

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        userDao = db.provideUserDao()
        initData()
    }

    private fun initData() {
        for (n in 1..5) {
            val userEntity = UserDataBaseModel(
                id = n, name = "name$n", email = "email$n", gender = "gender$n", status = "status$n"
            )
            modelList.add(userEntity)
            userDao.insertAll(userEntity)
        }
    }

    @After
    fun close() {
        db.close()
    }

    @Test
    fun whenGetAllIsCalled_thenCorrectAmountOfItemsIsReturned() {
        val result = userDao.getAll()
        assertThat(result.size, equalTo(5))
    }

    @Test
    fun whenGetAllIsCalled_thenCorrectItemsAreReturned() {
        val result = userDao.getAll()
        assertThat(result, equalTo(modelList))
    }

    @Test
    fun whenLoadAllByIdsIsCalled_thenCorrectItemsAreReturned() {
        val result = userDao.loadAllByIds(intArrayOf(1, 2, 3, 4, 5))
        assertThat(result, equalTo(modelList))
    }

    @Test
    fun whenFindByNameIsCalled_thenCorrectItemIsReturned() {
        val result = userDao.findByName("name3")
        assertThat(result, equalTo(modelList[2]))
    }

    @Test
    fun whenInsertIsCalled_thenItemIsInserted() {
        val expected = UserDataBaseModel(
            id = 6,
            name = "name6",
            email = "email6",
            gender = "gender6",
            status = "status6",
        )
        userDao.insertAll(expected)

        val result = userDao.findByName("name6")
        assertThat(result, equalTo(expected))
    }

    @Test
    fun whenDeleteIsCalled_thenCorrectItemIsDeleted() {
        userDao.delete(
            UserDataBaseModel(
                id = 5,
                name = "name5",
                email = "email5",
                gender = "gender5",
                status = "status5",
            )
        )
        val result = userDao.getAll()
        modelList.removeLast()
        assertThat(result, equalTo(modelList))
    }
}