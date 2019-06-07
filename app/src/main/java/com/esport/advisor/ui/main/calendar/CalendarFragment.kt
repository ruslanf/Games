package com.esport.advisor.ui.main.calendar

import com.esport.advisor.root.BackPressedInterface
import studio.bz_soft.mvilibrary.mvi.MVIFragment

class CalendarFragment : MVIFragment(), BackPressedInterface {

    override fun onBackPressed(): Boolean {
        return true
    }

    companion object {
        fun instance() : CalendarFragment = CalendarFragment()
    }
}