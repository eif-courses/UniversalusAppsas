package eif.viko.lt.mg.universalusappsas.data.repository

import eif.viko.lt.mg.universalusappsas.data.remote.EmployeeApi
import eif.viko.lt.mg.universalusappsas.data.remote.EmployeeDto
import eif.viko.lt.mg.universalusappsas.domain.repository.EmployeeRepository
import eif.viko.lt.mg.universalusappsas.domain.util.Resource
import javax.inject.Inject

class EmployeeRepositoryImpl @Inject constructor(private val api: EmployeeApi) : EmployeeRepository{
    override suspend fun getEmployeeData(): Resource<EmployeeDto> {
        return try{
            Resource.Success(
                data = api.getEmployees()
            )
        }catch (e: Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: "Unknown error")
        }
    }

}