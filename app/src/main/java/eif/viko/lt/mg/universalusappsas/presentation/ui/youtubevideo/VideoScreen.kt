package eif.viko.lt.mg.universalusappsas.presentation.ui.youtubevideo

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import eif.viko.lt.mg.universalusappsas.presentation.ui.youtubevideo.components.ListItem


@Composable
fun VideoScreen(
    navController: NavController,
    viewModel: VideoViewModel = hiltViewModel(),
) {
    val state = viewModel.state.videos
    println("FIREBASE DUOMENU NERA: $state")

    ListItem(items = state)
}