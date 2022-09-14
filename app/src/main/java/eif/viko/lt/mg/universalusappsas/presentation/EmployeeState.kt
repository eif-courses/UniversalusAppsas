package eif.viko.lt.mg.universalusappsas.presentation

import eif.viko.lt.mg.universalusappsas.data.remote.EmployeeDto

data class EmployeeState(
    val employee: EmployeeDto? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
