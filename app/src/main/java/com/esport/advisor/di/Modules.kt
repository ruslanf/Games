package com.esport.advisor.di

import android.content.Context
import com.esport.advisor.root.App
import com.esport.advisor.root.Constants
import com.esport.advisor.root.MainRouter
import kotlinx.coroutines.channels.Channel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

val appModule = module {
    single { androidApplication() as App }
    factory { (name: String) -> get<App>().getSharedPreferences(name, Context.MODE_PRIVATE) }

    single { com.esport.advisor.data.http.ApiClient(
        Constants.API_MAIN_URL,
        androidContext()
    ) as com.esport.advisor.data.http.ApiClientInterface
    }

    single { com.esport.advisor.data.Repository(get()) }
}

val navigatorModule = module {
    single { Cicerone.create() }
    single { get<Cicerone<Router>>().router as Router }
    single { get<Cicerone<Router>>().navigatorHolder as NavigatorHolder }
    single { MainRouter(get(), Channel(Channel.UNLIMITED)).apply { start() } }
}