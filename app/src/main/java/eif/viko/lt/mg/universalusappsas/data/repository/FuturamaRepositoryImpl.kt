package eif.viko.lt.mg.universalusappsas.data.repository

import eif.viko.lt.mg.universalusappsas.data.FuturamaApi
import eif.viko.lt.mg.universalusappsas.domain.model.Futurama
import eif.viko.lt.mg.universalusappsas.domain.repository.FuturamaRepository
import eif.viko.lt.mg.universalusappsas.domain.util.Resource
import javax.inject.Inject

class FuturamaRepositoryImpl @Inject constructor(
    private val api: FuturamaApi
): FuturamaRepository {
    override suspend fun getFuturamaCharacters(): Resource<List<Futurama>> {
        return try {
            Resource.Success(data = api.getAllCharacters().map { it.toFuturama() })
        }catch (e: Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: "Unknown error")
        }
    }
}