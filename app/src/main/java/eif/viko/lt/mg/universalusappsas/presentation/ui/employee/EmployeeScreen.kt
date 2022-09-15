package eif.viko.lt.mg.universalusappsas.presentation.ui.employee

import androidx.compose.runtime.Composable

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import eif.viko.lt.mg.universalusappsas.domain.util.Route
import eif.viko.lt.mg.universalusappsas.presentation.ui.employee.components.ListItem

@Composable
fun EmployeeScreen(
    navController: NavController,
    viewModel: EmployeeViewModel = hiltViewModel()
) {
    viewModel.loadEmployees()
    val state = viewModel.state

   ListItem(
        items = state.employees,
        onItemClick = {
            navController.navigate(Route.EMPLOYEE_DETAILS)
        }
    )
}