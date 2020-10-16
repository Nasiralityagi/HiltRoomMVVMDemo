package com.android.offlineexample.data.cache.entity

import com.android.offlineexample.data.model.Picture


data class PictureModel(
    val large: String,
    val medium: String,
    val thumbnail: String
)

fun PictureModel.toDomain() = Picture(
    large = large,
    medium = medium,
    thumbnail = thumbnail
)