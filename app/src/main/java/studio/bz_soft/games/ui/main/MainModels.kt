package studio.bz_soft.games.ui.main

//import studio.bz_soft.games.data.models.NewsModel

data class MainState(
//    val ic_news: LoadModel<NewsModel> = LoadModel.Promised(),
    val currentScreen: MainScreens = MainScreens.News
)

sealed class MainIntent {
    object Back : MainIntent()
    data class OnNavigate(val screen: MainScreens) : MainIntent()
}

sealed class MainAction

sealed class MainRender {
    data class RenderScreen(val screen: MainScreens) : MainRender()
}

sealed class MainScreens {
    object News : MainScreens()
    object Results : MainScreens()
    object Calendar : MainScreens()
    object Commands : MainScreens()
    object Tournaments : MainScreens()
}