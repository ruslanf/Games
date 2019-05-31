package studio.bz_soft.games.ui.main.news

import studio.bz_soft.games.root.BackPressedInterface
import studio.bz_soft.mvilibrary.mvi.MVIFragment

class NewsFragment : MVIFragment(), BackPressedInterface {

    override fun onBackPressed(): Boolean {
        return true
    }

    companion object {
        fun instance() : NewsFragment = NewsFragment()
    }
}