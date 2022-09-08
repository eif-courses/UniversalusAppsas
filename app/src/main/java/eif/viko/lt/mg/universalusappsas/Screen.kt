package eif.viko.lt.mg.universalusappsas

sealed class Screen(val route: String){
    object DetailsScreen: Screen("details_screen")
    object HomeScreen: Screen("home_screen")
}
