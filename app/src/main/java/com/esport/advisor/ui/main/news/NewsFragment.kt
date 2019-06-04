package com.esport.advisor.ui.main.news

import com.esport.advisor.root.BackPressedInterface
import studio.bz_soft.mvilibrary.mvi.MVIFragment

class NewsFragment : MVIFragment(), BackPressedInterface {

    override fun onBackPressed(): Boolean {
        return true
    }

    companion object {
        fun instance() : NewsFragment = NewsFragment()
    }
}