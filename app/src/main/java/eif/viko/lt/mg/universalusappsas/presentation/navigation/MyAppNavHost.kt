package eif.viko.lt.mg.universalusappsas.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import eif.viko.lt.mg.universalusappsas.domain.util.Route
import eif.viko.lt.mg.universalusappsas.presentation.ui.futurama.FuturamaDetailsScreen
import eif.viko.lt.mg.universalusappsas.presentation.ui.futurama.FuturamaScreen
import eif.viko.lt.mg.universalusappsas.presentation.ui.youtubevideo.VideoScreen

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Route.FUTURAMA_CHARACTERS_SCREEN
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Route.FUTURAMA_CHARACTERS_SCREEN) {
            FuturamaScreen(navController = navController)
        }
        composable(route = Route.FUTURAMA_VIDEOS_SCREEN){
            VideoScreen(navController = navController)
        }
        composable(
            route = "${Route.FUTURAMA_CHARACTER_DETAILS}/{profession}/{imageUrl}/{name}",
            arguments = listOf(
                navArgument("profession") { type = NavType.StringType },
                navArgument("imageUrl") { type = NavType.StringType },
                navArgument("name") { type = NavType.StringType }
            )) {backStackEntry ->
            FuturamaDetailsScreen(
                navController = navController,
                profession = backStackEntry.arguments?.getString("profession"),
                imageUrl = backStackEntry.arguments?.getString("imageUrl"),
                name = backStackEntry.arguments?.getString("name"))
        }
    }
}
