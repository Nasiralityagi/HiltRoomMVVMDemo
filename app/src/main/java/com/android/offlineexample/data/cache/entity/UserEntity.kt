package com.android.offlineexample.data.cache.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    val gender: String,
    val title: String,
    val first: String,
    val lastName: String,
    val email: String,
    val imageLarge: String,
    val imageMedium: String,
    val thumbnail: String,
    val favourite: Boolean
)

fun UserEntity.toData() = UserModel(
    id = id,
    gender = gender,
    name = NameModel(title, first, lastName),
    email = email,
    picture = PictureModel(imageLarge, imageMedium, thumbnail),
    favourite = favourite
)