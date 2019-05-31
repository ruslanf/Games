package studio.bz_soft.games.ui.main.commands

import studio.bz_soft.games.root.BackPressedInterface
import studio.bz_soft.mvilibrary.mvi.MVIFragment

class CommandsFragment : MVIFragment(), BackPressedInterface {

    override fun onBackPressed(): Boolean {
        return true
    }

    companion object {
        fun instance() : CommandsFragment = CommandsFragment()
    }
}