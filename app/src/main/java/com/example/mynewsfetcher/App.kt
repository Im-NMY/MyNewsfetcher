package com.example.mynewsfetcher

import android.app.Application
import com.example.mynewsfetcher.feature.di.mainScreenModule
import com.example.mynewsfetcher.feature.mainscreen.MainScreenViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate(){
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule, mainScreenModule)
        }
    }

}