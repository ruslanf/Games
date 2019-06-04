package com.esport.advisor.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.esport.advisor.R
import com.esport.advisor.root.BackPressedInterface
import com.esport.advisor.ui.main.calendar.CalendarFragment
import com.esport.advisor.ui.main.commands.CommandsFragment
import com.esport.advisor.ui.main.news.NewsFragment
import com.esport.advisor.ui.main.results.ResultsFragment
import com.esport.advisor.ui.main.tournaments.TournamentsFragment
import kotlinx.android.synthetic.main.fragment_main.view.*
import org.koin.android.ext.android.get
import studio.bz_soft.mvilibrary.mvi.MVIFragment

class MainFragment : MVIFragment(), BackPressedInterface {

    private val controller: MainController by registered(
            { v, r -> render(v, r) }
    ) { MainController(get()) }

    private val newsFragment = NewsFragment.instance()
    private val resultsFragment = ResultsFragment.instance()
    private val calendarFragment = CalendarFragment.instance()
    private val commandsFragment = CommandsFragment.instance()
    private val tournamentsFragment = TournamentsFragment.instance()

    private fun render(v: View, r: MainRender) {
        return when (r) {
            is MainRender.RenderScreen -> renderFragment(v, r.screen)
        }
    }

    private fun renderFragment(v: View, screen: MainScreens) {
        v.apply {
            childFragmentManager.beginTransaction().replace(v.flMain.id, when (screen) {
                is MainScreens.News -> newsFragment
                is MainScreens.Results -> resultsFragment
                is MainScreens.Calendar -> calendarFragment
                is MainScreens.Commands -> commandsFragment
                is MainScreens.Tournaments -> tournamentsFragment
            }).commit()
        }
    }

    private fun getCurrentFragment(): Fragment? =
            view?.let {
                childFragmentManager.findFragmentById(it.flMain.id)
            }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.apply {
            mainBottomNavigationMenu.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.menuTitleNews -> {
                        controller.sendIntent(MainIntent.OnNavigate(MainScreens.News))
                        true
                    }
                    R.id.menuTitleResults -> {
                        controller.sendIntent(MainIntent.OnNavigate(MainScreens.Results))
                        true
                    }
                    R.id.menuTitleCalendar -> {
                        controller.sendIntent(MainIntent.OnNavigate(MainScreens.Calendar))
                        true
                    }
                    R.id.menuTitleCommands -> {
                        controller.sendIntent(MainIntent.OnNavigate(MainScreens.Commands))
                        true
                    }
                    R.id.menuTitleTournaments -> {
                        controller.sendIntent(MainIntent.OnNavigate(MainScreens.Tournaments))
                        true
                    }
                    else -> false
                }
            }
        }
    }

    override fun onBackPressed(): Boolean {
        controller.sendIntent(MainIntent.Back)
        return (getCurrentFragment() as? BackPressedInterface)?.onBackPressed() ?: false
    }

    companion object {
        fun instance(): MainFragment = MainFragment()
    }
}