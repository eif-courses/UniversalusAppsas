package eif.viko.lt.mg.universalusappsas.domain.repository

import eif.viko.lt.mg.universalusappsas.domain.model.Employee
import eif.viko.lt.mg.universalusappsas.domain.util.Resource

interface EmployeeRepository {
    suspend fun getEmployeeData(): Resource<List<Employee>>
}