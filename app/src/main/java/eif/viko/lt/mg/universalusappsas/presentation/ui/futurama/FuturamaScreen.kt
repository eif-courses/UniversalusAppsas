package eif.viko.lt.mg.universalusappsas.presentation.ui.futurama

import androidx.compose.runtime.Composable

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import eif.viko.lt.mg.universalusappsas.domain.util.Route
import eif.viko.lt.mg.universalusappsas.presentation.ui.futurama.components.ListItem
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun FuturamaScreen(
    navController: NavController,
    viewModel: FuturamaViewModel = hiltViewModel(),
) {
    val state = viewModel.state.characters
    //profession}/{imageUrl}/{name
    ListItem(
        items = state,
        onItemClick = {
            // Url perdavimui reikia užkuoduoti
            val encodedUrl = URLEncoder.encode(it.PicUrl, StandardCharsets.UTF_8.toString())

            navController.navigate(Route.FUTURAMA_CHARACTER_DETAILS+"/${it.Profession}/$encodedUrl/${it.Name}")
        }
    )
}