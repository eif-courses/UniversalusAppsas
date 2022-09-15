package eif.viko.lt.mg.universalusappsas.presentation.ui.components.layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import eif.viko.lt.mg.universalusappsas.domain.util.Route
import eif.viko.lt.mg.universalusappsas.presentation.ui.employee.EmployeeDetailsScreen
import eif.viko.lt.mg.universalusappsas.presentation.ui.employee.EmployeeScreen

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Route.EMPLOYEE
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Route.EMPLOYEE) {
            EmployeeScreen(navController = navController)
        }
        composable(Route.EMPLOYEE_DETAILS) {
            EmployeeDetailsScreen(navController = navController)
        }
    }
}
