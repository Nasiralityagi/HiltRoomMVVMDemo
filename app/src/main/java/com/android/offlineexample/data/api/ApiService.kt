package com.android.offlineexample.data.api

import com.android.offlineexample.data.cache.entity.UserResponse
import com.android.offlineexample.data.model.BaseResponse
import com.android.offlineexample.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("api/?results=20")
    suspend fun getUsers(): Response<BaseResponse<List<UserResponse>>>
}