package com.android.offlineexample.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.offlineexample.data.cache.entity.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    suspend fun getAll(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<UserEntity>)

    @Query("SELECT * FROM User WHERE id = :userId")
    suspend fun getUserById(userId: Long): UserEntity

    @Query("DELETE FROM User")
    suspend fun deleteAll()

}
