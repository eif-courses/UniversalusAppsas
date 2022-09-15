package eif.viko.lt.mg.universalusappsas.presentation.ui.employee

import eif.viko.lt.mg.universalusappsas.domain.model.Employee

data class EmployeeState(
    val employees: List<Employee> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
