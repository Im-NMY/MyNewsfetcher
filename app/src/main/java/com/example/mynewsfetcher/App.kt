package com.example.mynewsfetcher

import android.app.Application
import com.example.mynewsfetcher.di.databaseModule
import com.example.mynewsfetcher.di.networkModule
import com.example.mynewsfetcher.feature.bookmarks.di.bookmarksModule
import com.example.mynewsfetcher.feature.mainscreen.di.mainScreenModule
import com.example.mynewsfetcher.feature.newsinfo.di.infoScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                networkModule,
                mainScreenModule,
                bookmarksModule,
                databaseModule,
                infoScreenModule
            )
        }
    }
}