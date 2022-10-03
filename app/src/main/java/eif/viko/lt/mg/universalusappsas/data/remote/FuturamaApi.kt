package eif.viko.lt.mg.universalusappsas.data.remote

import eif.viko.lt.mg.universalusappsas.data.remote.FuturamaDto
import retrofit2.http.GET

interface FuturamaApi {

    @GET("/api/v2/characters")
    suspend fun getAllCharacters(): List<FuturamaDto>


    companion object {
        const val BASE_URL = "https://futuramaapi.herokuapp.com/"
    }
}