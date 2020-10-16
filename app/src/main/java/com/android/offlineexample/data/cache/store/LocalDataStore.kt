package com.android.offlineexample.data.cache.store

import com.android.offlineexample.data.cache.dao.UserDao
import com.android.offlineexample.data.cache.entity.UserModel
import com.android.offlineexample.data.cache.entity.toData
import com.android.offlineexample.data.cache.entity.toLocal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalDataStore @Inject constructor(
    private val userDao: UserDao,
    private val prefHelper: PrefHelper
) {

    companion object {
        private const val EXPIRATION_TIME = (60 * 10 * 1000).toLong()
    }

    suspend fun getUsers(): List<UserModel> = withContext(Dispatchers.IO) {
        userDao.getAll().map { it.toData() }
    }

    suspend fun getUser(userId: Long): UserModel = withContext(Dispatchers.IO) {
        userDao.getUserById(userId).toData()
    }

    suspend fun saveUsers(users: List<UserModel>): List<UserModel> = withContext(Dispatchers.IO) {
        userDao.deleteAll()
        userDao.insertAll(users.map { it.toLocal() })
        setLastCacheTime(System.currentTimeMillis())
        userDao.getAll().map { it.toData() }
    }

    private fun setLastCacheTime(lastCache: Long) {
        prefHelper.lastCacheTime = lastCache
    }

    private fun getLastCacheUpdateTimeMillis(): Long {
        return prefHelper.lastCacheTime
    }

    fun isExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = this.getLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }
}