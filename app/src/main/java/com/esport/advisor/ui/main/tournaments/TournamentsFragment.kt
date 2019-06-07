package com.esport.advisor.ui.main.tournaments

import com.esport.advisor.root.BackPressedInterface
import studio.bz_soft.mvilibrary.mvi.MVIFragment

class TournamentsFragment : MVIFragment(), BackPressedInterface {

    override fun onBackPressed(): Boolean {
        return true
    }

    companion object {
        fun instance() : TournamentsFragment = TournamentsFragment()
    }
}