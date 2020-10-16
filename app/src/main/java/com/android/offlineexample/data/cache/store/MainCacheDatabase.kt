package com.android.offlineexample.data.cache.store

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.offlineexample.data.cache.dao.UserDao
import com.android.offlineexample.data.cache.entity.UserEntity
import com.android.offlineexample.data.model.User

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class MainCacheDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        val DATABASE_NAME: String = "app_db_name"
        /*fun newInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "my-app.db").build()
        }*/
    }
}