package eif.viko.lt.mg.universalusappsas.data.remote

import retrofit2.http.GET

interface EmployeeApi {
    @GET("/.json")
    suspend fun getEmployees():EmployeeDto
}