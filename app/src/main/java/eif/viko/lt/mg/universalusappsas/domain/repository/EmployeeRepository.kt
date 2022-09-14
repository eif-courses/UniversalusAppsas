package eif.viko.lt.mg.universalusappsas.domain.repository

import eif.viko.lt.mg.universalusappsas.data.remote.EmployeeDto
import eif.viko.lt.mg.universalusappsas.domain.util.Resource

interface EmployeeRepository {
    suspend fun getEmployeeData(): Resource<EmployeeDto>
}