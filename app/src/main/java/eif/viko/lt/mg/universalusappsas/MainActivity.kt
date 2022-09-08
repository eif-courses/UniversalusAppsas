package eif.viko.lt.mg.universalusappsas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import eif.viko.lt.mg.universalusappsas.ui.theme.UniversalusAppsasTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            UniversalusAppsasTheme {
                val dummyList = listOf(
                    MenuItem(
                        "add",
                        "Add",
                        "prideti",
                        Icons.Default.Add
                    ),
                    MenuItem(
                        "create",
                        "Create",
                        "Sukurti",
                        Icons.Default.Create
                    ),
                    MenuItem(
                        "delete",
                        "Delete",
                        "Istrinti",
                        Icons.Default.Delete
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
                            println("Clicked on ${it.title}")
                            navController.navigate("profile")
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
}


//@Composable
//fun NavigationGraph(
//    modifier: Modifier = Modifier,
//    navController: NavHostController = rememberNavController(),
//    startDestination: String = Screen.HomeScreen.route
//    ) {
//
//    NavHost(
//        modifier = modifier,
//        navController = navController,
//        startDestination = startDestination
//    ) {
//        composable(route = Screen.HomeScreen.route) {
//            HomeScreen(navController)
//        }
//        composable(route = Screen.DetailsScreen.route) {
//            DetailsScreen(navController)
//        }
//    }
//}


@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "profile"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("profile") {
            ProfileScreen(
                onNavigateToFriends = { navController.navigate("another") },
                /*...*/
            )
        }
        composable("another") {
            AnotherScreen(onNavigateToFriends = {
                navController.navigate("profile")
            }
            )

        }
    }
}

@Composable
fun ProfileScreen(
    onNavigateToFriends: () -> Unit,
    /*...*/
) {
    /*...*/
    Button(onClick = onNavigateToFriends) {
        Text(text = "See friends list")
    }
}

@Composable
fun AnotherScreen(
    onNavigateToFriends: () -> Unit,
    /*...*/
) {
    /*...*/
    Button(onClick = onNavigateToFriends) {
        Text(text = "Kitas ekranas")
    }
}

//@Composable
//fun NavigationGraph(navController: NavHostController) {
//    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
//        composable(BottomNavItem.Home.screen_route) {
//            HomeScreen()
//        }
//        composable(BottomNavItem.MyNetwork.screen_route) {
//            NetworkScreen()
//        }
//        composable(BottomNavItem.AddPost.screen_route) {
//            AddPostScreen()
//        }
//        composable(BottomNavItem.Notification.screen_route) {
//            NotificationScreen()
//        }
//        composable(BottomNavItem.Jobs.screen_route) {
//            JobScreen()
//        }
//    }
//}


//@Preview
@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Toggle drawer"
                )
            }
        }
    )
}

@Preview
@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(64.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Header", fontSize = 40.sp)
    }
}


@Composable
fun DrawerBody(
    modifier: Modifier = Modifier,
    items: List<MenuItem>,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (MenuItem) -> Unit
) {
    // Text(text = "waea: ${items}")

    LazyColumn(modifier) {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(item)
                    }
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.contentDescription
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    style = itemTextStyle,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    val dummyData = listOf(
        MenuItem(
            "1",
            "Pirmas",
            "Aprasymas",
            Icons.Default.ThumbUp
        ),
        MenuItem(
            "2",
            "Antras",
            "Aprasymas",
            Icons.Default.ThumbUp
        ),
        MenuItem(
            "2",
            "Trecias",
            "Aprasymas",
            Icons.Default.ThumbUp
        ),
        MenuItem(
            "2",
            "Ketvirtas",
            "Aprasymas",
            Icons.Default.ThumbUp
        )
    )

    UniversalusAppsasTheme {
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        Scaffold(
            topBar = {
                AppBar(
                    onNavigationIconClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }
                )

            },
            drawerContent = {
                DrawerHeader()
                DrawerBody(items = dummyData, onItemClick = {
                    println("Clicked on ${it.title}")
                })
            }) {
            Box(modifier = Modifier.padding(it))
        }

    }
}