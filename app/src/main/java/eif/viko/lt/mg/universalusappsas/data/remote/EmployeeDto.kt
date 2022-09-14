package eif.viko.lt.mg.universalusappsas.data.remote

import com.squareup.moshi.Json


data class Employee(
    val address: String = "",
    val age: Int = 0,
    val name: String = "",
)

data class EmployeeDto(
    @field:Json(name = "employees")
    val employeeData: List<Employee>
)