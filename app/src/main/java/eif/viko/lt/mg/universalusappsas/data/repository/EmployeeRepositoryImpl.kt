package eif.viko.lt.mg.universalusappsas.data.repository

import eif.viko.lt.mg.universalusappsas.data.EmployeeApi
import eif.viko.lt.mg.universalusappsas.data.remote.EmployeeDto
import eif.viko.lt.mg.universalusappsas.domain.model.Employee
import eif.viko.lt.mg.universalusappsas.domain.repository.EmployeeRepository
import eif.viko.lt.mg.universalusappsas.domain.util.Resource
import javax.inject.Inject

class EmployeeRepositoryImpl @Inject constructor(private val api: EmployeeApi) : EmployeeRepository{
    override suspend fun getEmployeeData(): Resource<List<Employee>> {
        return try{
            Resource.Success(
                data = api.getEmployees().map { it.toEmployee() }
            )
        }catch (e: Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: "Unknown error")
        }
    }

}