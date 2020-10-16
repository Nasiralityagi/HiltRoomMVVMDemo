package com.android.offlineexample.data.cache.store

import com.android.offlineexample.data.api.ApiService
import com.android.offlineexample.data.cache.entity.UserModel
import com.android.offlineexample.data.cache.entity.toData
import com.android.offlineexample.exception.NotFoundException
import com.android.offlineexample.utils.NetworkHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CloudDataStore @Inject constructor(
    private val api: ApiService,
    private val networkHelper: NetworkHelper
) {

    suspend fun getUsers(): List<UserModel> = withContext(Dispatchers.IO) {
        if (networkHelper.isInternetOn()) {
            api.getUsers().let { response ->
                response.body()?.results?.map { it.toData() } ?: throw NotFoundException()
            }
        } else {
            arrayListOf()
        }
    }
}