package eif.viko.lt.mg.universalusappsas.data

import eif.viko.lt.mg.universalusappsas.data.remote.EmployeeDto
import retrofit2.http.GET

interface EmployeeApi {

    @GET("/employees.json")
    suspend fun getEmployees(): List<EmployeeDto>

    companion object {
        const val BASE_URL = "https://saltoniskes.firebaseio.com/"
    }
}