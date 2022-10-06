package eif.viko.lt.mg.universalusappsas.presentation.ui.youtubevideos

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun YoutubeVideoScreen(
    navController: NavController,
    viewModel: YoutubeVideoViewModel = hiltViewModel()
) {

    val state = viewModel.state.videos

   state.forEach {
       println("${it.url} , ${it.title}")
   }


}