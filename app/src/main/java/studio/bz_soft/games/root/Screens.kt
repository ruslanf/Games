package studio.bz_soft.games.root

import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen
import studio.bz_soft.games.ui.main.MainFragment
import studio.bz_soft.games.ui.main.news.NewsFragment

sealed class Screens : SupportAppScreen() {

    object MainScreen : Screens() {
        override fun getFragment(): Fragment = MainFragment.instance()
    }

//    data class DetailedNewsScreen(val ic_news: Article) : Screens() {
//        override fun getFragment(): Fragment = DetailedNewsFragment.instance(ic_news)
//    }
//
    object NewsScreen : Screens() {
        override fun getFragment(): Fragment = NewsFragment.instance()
    }
}