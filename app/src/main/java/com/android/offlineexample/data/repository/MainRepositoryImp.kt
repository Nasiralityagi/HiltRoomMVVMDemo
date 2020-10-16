package com.android.offlineexample.data.repository

import com.android.offlineexample.data.cache.entity.toDomain
import com.android.offlineexample.data.cache.store.CloudDataStore
import com.android.offlineexample.data.cache.store.LocalDataStore
import com.android.offlineexample.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepositoryImp @Inject constructor(
    private val cloudDataStore: CloudDataStore,
    private val localDataStore: LocalDataStore
) : MainRepository {

    override suspend fun getUsers(refresh: Boolean): List<User> = withContext(Dispatchers.IO) {
        val userLocalList = getUsersFromLocal()
        if (userLocalList.isNotEmpty() && !refresh) {
            if (localDataStore.isExpired()) {
                getUsersFromRemote()
            } else {
                getUsersFromLocal()
            }
        } else {
            getUsersFromRemote()
        }
    }

    private suspend fun getUsersFromRemote(): List<User> = withContext(Dispatchers.IO) {
        val usersFromRemote = cloudDataStore.getUsers()
        if (usersFromRemote.isNotEmpty()) {
            localDataStore.saveUsers(usersFromRemote).map { it.toDomain() }
        } else {
            getUsersFromLocal()
        }
    }

    private suspend fun getUsersFromLocal(): List<User> = withContext(Dispatchers.IO) {
        localDataStore.getUsers().map { it.toDomain() }
    }

    override suspend fun getUser(userId: Long): User = withContext(Dispatchers.IO) {
        localDataStore.getUser(userId).toDomain()
    }

    override suspend fun deleteUser(user: User) {
        //TODO("Not yet implemented")
    }

}