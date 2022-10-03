package eif.viko.lt.mg.universalusappsas.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import dagger.hilt.android.AndroidEntryPoint
import eif.viko.lt.mg.universalusappsas.domain.util.Route
import eif.viko.lt.mg.universalusappsas.presentation.navigation.MyAppNavHost
import eif.viko.lt.mg.universalusappsas.presentation.ui.components.layout.*

import eif.viko.lt.mg.universalusappsas.presentation.ui.theme.UniversalusAppsasTheme
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            UniversalusAppsasTheme {
                val dummyList = listOf(
                    MenuItem(
                        Route.FUTURAMA_CHARACTERS_SCREEN,
                        "Characters",
                        "characters",
                        Icons.Default.Person
                    ),
                    MenuItem(
                        Route.FUTURAMA_VIDEOS_SCREEN,
                        "Videos",
                        "videos",
                        Icons.Default.PlayArrow
                    )
                )
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        AppBar(
                            onNavigationIconClick = {
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }
                        )

                    },
                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
                    drawerContent = {

                        DrawerHeader()
                        DrawerBody(items = dummyList, onItemClick = {

                            navController.navigate(it.id)

                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                        })
                    }) {
                    MyAppNavHost(
                        Modifier.padding(it),
                        navController = navController,
                    )
                }

            }
        }
    }

    data class Artist(val name: String)

    @Composable
    fun ArtistCard(
        artist: Artist,
        onClick: () -> Unit
    ) {
        val padding = 16.dp
        Column(
            Modifier
                .clickable(onClick = onClick)
                .padding(padding)
                .fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = artist.name,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(Modifier.size(padding))
            Card(elevation = 4.dp) {
                AsyncImage(
                    modifier = Modifier.fillMaxWidth(),
                    model = "https://www.lamborghini.com/sites/it-en/files/DAM/lamborghini/facelift_2019/homepage/families-gallery/2022/04_12/family_chooser_tecnica_m.png",
                    contentDescription = "aprasymas",
                )
            }
        }
    }

    @Composable
    @Preview
    fun DefaultView() {
        ArtistCard(
            artist = Artist("Marius"),
            onClick = {

            }
        )
    }


}



