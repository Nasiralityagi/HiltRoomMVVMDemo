package com.android.offlineexample.data.cache.store

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PrefHelper @Inject constructor(@ApplicationContext private val context: Context) {

    companion object{
        private const val PREF_PACKAGE_NAME = "com.android.offlineexample"
        private const val PREF_KEY_LAST_CACHE = "last_cache"
    }

    private val appPref: SharedPreferences

    init {
        appPref = context.getSharedPreferences(PREF_PACKAGE_NAME, Context.MODE_PRIVATE)
    }

    var lastCacheTime: Long
    get() = appPref.getLong(PREF_KEY_LAST_CACHE, 0)
    set(lastCache) = appPref.edit().putLong(PREF_KEY_LAST_CACHE, lastCache).apply()

}