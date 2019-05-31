package studio.bz_soft.games.di

import android.content.Context
import kotlinx.coroutines.channels.Channel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import studio.bz_soft.games.data.Repository
import studio.bz_soft.games.data.http.ApiClient
import studio.bz_soft.games.data.http.ApiClientInterface
import studio.bz_soft.games.root.App
import studio.bz_soft.games.root.Constants
import studio.bz_soft.games.root.MainRouter

val appModule = module {
    single { androidApplication() as App }
    factory { (name: String) -> get<App>().getSharedPreferences(name, Context.MODE_PRIVATE) }

    single { ApiClient(Constants.API_MAIN_URL, androidContext()) as ApiClientInterface }

    single { Repository(get()) }
}

val navigatorModule = module {
    single { Cicerone.create() }
    single { get<Cicerone<Router>>().router as Router }
    single { get<Cicerone<Router>>().navigatorHolder as NavigatorHolder }
    single { MainRouter(get(), Channel(Channel.UNLIMITED)).apply { start() } }
}