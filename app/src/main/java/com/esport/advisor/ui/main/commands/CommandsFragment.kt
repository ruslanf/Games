package com.esport.advisor.ui.main.commands

import com.esport.advisor.root.BackPressedInterface
import studio.bz_soft.mvilibrary.mvi.MVIFragment

class CommandsFragment : MVIFragment(), BackPressedInterface {

    override fun onBackPressed(): Boolean {
        return true
    }

    companion object {
        fun instance() : CommandsFragment = CommandsFragment()
    }
}