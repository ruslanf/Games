package com.esport.advisor.root

import androidx.fragment.app.Fragment
import com.esport.advisor.ui.main.MainFragment
import com.esport.advisor.ui.main.news.NewsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

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