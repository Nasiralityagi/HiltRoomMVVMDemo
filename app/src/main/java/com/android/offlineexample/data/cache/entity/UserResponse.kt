package com.android.offlineexample.data.cache.entity

import com.android.offlineexample.data.cache.entity.UserModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName("gender")
    val gender: String,
    @SerialName("name")
    val name: NameResponse,
    @SerialName("email")
    val email: String,
    @SerialName("phone")
    val phone: String,
    @SerialName("cell")
    val cell: String,
    @SerialName("picture")
    val picture: PictureResponse,
    @SerialName("nat")
    val nat: String
)

fun UserResponse.toData() = UserModel(
    gender = gender,
    name = name.toData(),
    email = email,
    picture = picture.toData(),
    favourite = false
)