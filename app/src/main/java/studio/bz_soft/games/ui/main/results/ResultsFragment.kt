package studio.bz_soft.games.ui.main.results

import studio.bz_soft.games.root.BackPressedInterface
import studio.bz_soft.mvilibrary.mvi.MVIFragment

class ResultsFragment : MVIFragment(), BackPressedInterface {

    override fun onBackPressed(): Boolean {
        return true
    }

    companion object {
        fun instance() : ResultsFragment = ResultsFragment()
    }
}