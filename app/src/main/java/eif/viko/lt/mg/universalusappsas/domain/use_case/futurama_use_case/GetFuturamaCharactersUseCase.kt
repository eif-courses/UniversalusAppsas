package eif.viko.lt.mg.universalusappsas.domain.use_case.futurama_use_case

import eif.viko.lt.mg.universalusappsas.domain.model.Futurama
import eif.viko.lt.mg.universalusappsas.domain.repository.FuturamaRepository
import eif.viko.lt.mg.universalusappsas.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFuturamaCharactersUseCase @Inject constructor(
    private val repository: FuturamaRepository
) {
    operator fun invoke(): Flow<Resource<List<Futurama>>> {
        return repository.getFuturamaCharacters()
    }
}