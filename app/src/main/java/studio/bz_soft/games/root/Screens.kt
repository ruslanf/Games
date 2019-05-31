package studio.bz_soft.games.root

import androidx.fragment.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen
//import studio.bz_soft.games.data.models.Article
import studio.bz_soft.games.ui.main.MainFragment
//import studio.bz_soft.games.ui.main.detailednews.DetailedNewsFragment
//import studio.bz_soft.games.ui.main.newsupdates.NewsUpdatesFragment

sealed class Screens : SupportAppScreen() {

    object MainScreen : Screens() {
        override fun getFragment(): Fragment = MainFragment.instance()
    }

//    data class DetailedNewsScreen(val ic_news: Article) : Screens() {
//        override fun getFragment(): Fragment = DetailedNewsFragment.instance(ic_news)
//    }
//
//    object NewsUpdatesScreen : Screens() {
//        override fun getFragment(): Fragment = NewsUpdatesFragment.instance()
//    }
}