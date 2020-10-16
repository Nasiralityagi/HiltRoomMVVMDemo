package com.android.offlineexample.data.model

import com.squareup.moshi.Json

open class BaseResponse<T> {
    var info: InfoResponse? = null
    var results: T? = null
}