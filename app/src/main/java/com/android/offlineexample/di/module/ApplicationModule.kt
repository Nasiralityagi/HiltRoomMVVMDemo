package com.android.offlineexample.di.module

import android.content.Context
import androidx.room.Room
import com.android.offlineexample.BuildConfig
import com.android.offlineexample.data.api.ApiService
import com.android.offlineexample.data.cache.dao.UserDao
import com.android.offlineexample.data.cache.store.MainCacheDatabase
import com.android.offlineexample.data.cache.store.PrefHelper
import com.android.offlineexample.data.cache.store.CloudDataStore
import com.android.offlineexample.data.cache.store.LocalDataStore
import com.android.offlineexample.data.repository.MainRepository
import com.android.offlineexample.data.repository.MainRepositoryImp
import com.android.offlineexample.utils.NetworkHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ApplicationModule {

    @Provides
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.apply { loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY }
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()


    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        BASE_URL: String
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideMainRepositoryHelper(mainRepository: MainRepositoryImp): MainRepository =
        mainRepository


    @Provides
    @Singleton
    fun provideCacheDb(@ApplicationContext context: Context): MainCacheDatabase {
        return Room.databaseBuilder(
            context, MainCacheDatabase::class.java,
            MainCacheDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideCacheDao(mainCacheDatabase: MainCacheDatabase): UserDao = mainCacheDatabase.userDao()

    @Singleton
    @Provides
    fun providePrefHelper(@ApplicationContext context: Context): PrefHelper {
        return PrefHelper(context)
    }

    @Singleton
    @Provides
    fun provideMainRepositoryImp(
        cloudDataStore: CloudDataStore,
        localDataStore: LocalDataStore
    ): MainRepositoryImp {
        return MainRepositoryImp(cloudDataStore, localDataStore)
    }

    @Singleton
    @Provides
    fun provideLocalDataStore(userDao: UserDao, prefHelper: PrefHelper): LocalDataStore =
        LocalDataStore(userDao, prefHelper)

    @Singleton
    @Provides
    fun provideCloudDataStore(
        apiService: ApiService,
        networkHelper: NetworkHelper
    ): CloudDataStore = CloudDataStore(apiService, networkHelper)

    @Singleton
    @Provides
    fun provideNetworkHelper(@ApplicationContext context: Context): NetworkHelper =
        NetworkHelper(context)
}