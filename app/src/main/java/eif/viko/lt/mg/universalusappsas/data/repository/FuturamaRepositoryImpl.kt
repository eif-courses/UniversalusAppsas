package eif.viko.lt.mg.universalusappsas.data.repository

import eif.viko.lt.mg.universalusappsas.data.local.FuturamaDao
import eif.viko.lt.mg.universalusappsas.data.remote.FuturamaApi
import eif.viko.lt.mg.universalusappsas.domain.model.Futurama
import eif.viko.lt.mg.universalusappsas.domain.repository.FuturamaRepository
import eif.viko.lt.mg.universalusappsas.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class FuturamaRepositoryImpl @Inject constructor(
    private val api: FuturamaApi,
    private val dao: FuturamaDao
): FuturamaRepository {
    override fun getFuturamaCharacters(): Flow<Resource<List<Futurama>>> = flow {

        emit(Resource.Loading())

        val characters = dao.getAllFuturamaCharacters().map { it.toFuturama() }
        emit(Resource.Loading(data = characters))

        try{
            val remoteCharactersData = api.getAllCharacters()
            dao.insertFuturamaCharacters(remoteCharactersData.map { it.toFuturamaEntity() })

        }catch (e: HttpException){
            emit(Resource.Error(
                message = "Oops something went wrong!",
                data = characters
            ))
        }catch (e: IOException){
            emit(Resource.Error(
                message = "Error can't reach server, check your internet connection!",
                data = characters
            ))
        }
        val newCharactersData = dao.getAllFuturamaCharacters().map { it.toFuturama() }
        emit(Resource.Success(newCharactersData))

    }
}