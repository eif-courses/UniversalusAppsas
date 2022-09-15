package eif.viko.lt.mg.universalusappsas.presentation.ui.employee

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import eif.viko.lt.mg.universalusappsas.domain.util.Route
import eif.viko.lt.mg.universalusappsas.presentation.ui.employee.components.ListItem

@Composable
fun EmployeeDetailsScreen(
    navController: NavController,
    viewModel: EmployeeViewModel = hiltViewModel()
) {
    val state = viewModel.state
    
    Text(text = "Kitas langas")
    Button(onClick = {navController.navigate(Route.EMPLOYEE)}) {
        Text(text = "ATGAL")
    }

}