package studio.bz_soft.games.ui.main.tournaments

import studio.bz_soft.games.root.BackPressedInterface
import studio.bz_soft.mvilibrary.mvi.MVIFragment

class TournamentsFragment : MVIFragment(), BackPressedInterface {

    override fun onBackPressed(): Boolean {
        return true
    }

    companion object {
        fun instance() : TournamentsFragment = TournamentsFragment()
    }
}