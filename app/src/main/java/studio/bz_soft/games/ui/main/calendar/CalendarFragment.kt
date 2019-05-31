package studio.bz_soft.games.ui.main.calendar

import studio.bz_soft.games.root.BackPressedInterface
import studio.bz_soft.mvilibrary.mvi.MVIFragment

class CalendarFragment : MVIFragment(), BackPressedInterface {

    override fun onBackPressed(): Boolean {
        return true
    }

    companion object {
        fun instance() : CalendarFragment = CalendarFragment()
    }
}