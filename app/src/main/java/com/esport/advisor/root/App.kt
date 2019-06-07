package com.esport.advisor.root

import android.app.Application
import com.esport.advisor.di.appModule
import com.esport.advisor.di.navigatorModule
import org.koin.android.ext.android.startKoin

class App : Application() {

    private lateinit var instance: App

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin(androidContext = this@App, modules = listOf(appModule, navigatorModule))
    }
}