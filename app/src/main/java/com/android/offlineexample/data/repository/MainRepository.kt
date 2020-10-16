package com.android.offlineexample.data.repository

import com.android.offlineexample.data.model.User

interface MainRepository {
    suspend fun getUsers(refresh: Boolean): List<User>
    suspend fun getUser(id: Long): User
    suspend fun deleteUser(user: User)
}