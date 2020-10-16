package com.android.offlineexample.data.cache.entity

import com.android.offlineexample.data.model.Name

data class NameModel(
    val title: String,
    val first: String,
    val last: String
)

fun NameModel.toDomain() = Name(
    title = title,
    first = first,
    last = last
)