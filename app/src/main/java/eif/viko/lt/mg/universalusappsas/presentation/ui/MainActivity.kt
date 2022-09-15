package eif.viko.lt.mg.universalusappsas.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier

import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import eif.viko.lt.mg.universalusappsas.presentation.ui.employee.EmployeeState
import eif.viko.lt.mg.universalusappsas.presentation.ui.employee.EmployeeViewModel
import eif.viko.lt.mg.universalusappsas.presentation.ui.components.layout.*
import eif.viko.lt.mg.universalusappsas.presentation.ui.employee.EmployeeScreen
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
                        "details",
                        "Details",
                        "prideti",
                        Icons.Default.Add
                    ),
                    MenuItem(
                        "employee",
                        "Employee",
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
                    //EmployeeScreen(navController = navController)
                }

            }
        }
    }
}



