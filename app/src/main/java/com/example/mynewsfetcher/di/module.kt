package com.example.mynewsfetcher

import android.util.Log
import androidx.room.Room
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://newsapi.org/"

const val API_KEY = "71be7081729c4f3d85b2c199a9510d57"
const val APP_DATABASE = "APP_DATABASE"
const val BUNDLE_KEY_FOR_ARTICLE_MODEL = "article"

val networkModule = module {

    single<OkHttpClient> {
        OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor { massage ->
                Log.d("OkHttp", massage)
            }.apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        )
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }
}
val databaseModule = module {

    single {
        Room
            .databaseBuilder(androidContext(), AppDatabase::class.java, APP_DATABASE)
            .fallbackToDestructiveMigration()
            .build()
    }

    single {
        get<AppDatabase>().bookmarksDao()
    }
}