package com.android.offlineexample.data.cache.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PictureResponse(
    @SerialName("large")
    val large: String,
    @SerialName("medium")
    val medium: String,
    @SerialName("thumbnail")
    val thumbnail: String
)

fun PictureResponse.toData() = PictureModel(
    large = large,
    medium = medium,
    thumbnail = thumbnail
)