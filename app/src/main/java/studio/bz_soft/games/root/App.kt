package studio.bz_soft.games.root

import android.app.Application
import org.koin.android.ext.android.startKoin
import studio.bz_soft.games.di.appModule
import studio.bz_soft.games.di.navigatorModule

class App : Application() {

    private lateinit var instance: App

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin(androidContext = this@App, modules = listOf(appModule, navigatorModule))
    }
}