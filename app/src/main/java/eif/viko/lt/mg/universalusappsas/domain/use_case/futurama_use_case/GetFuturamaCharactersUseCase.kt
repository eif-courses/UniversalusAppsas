package eif.viko.lt.mg.universalusappsas.domain.use_case.futurama_use_case

import eif.viko.lt.mg.universalusappsas.domain.model.Futurama
import eif.viko.lt.mg.universalusappsas.domain.repository.FuturamaRepository
import eif.viko.lt.mg.universalusappsas.domain.util.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetFuturamaCharactersUseCase @Inject constructor(
    private val repository: FuturamaRepository
){
    operator fun invoke(): Flow<Resource<List<Futurama>>> = flow{
        while (true) {
            try {
                val characters = repository.getFuturamaCharacters()
                emit(Resource.Success(data = characters.data))
            } catch (e: IOException) {
                emit(Resource.Error(message = "Couldn't reach server. Check internet connection!"))
            }
        }
    }
}