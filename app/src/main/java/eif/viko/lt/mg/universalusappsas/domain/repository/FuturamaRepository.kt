package eif.viko.lt.mg.universalusappsas.domain.repository

import eif.viko.lt.mg.universalusappsas.domain.model.Futurama
import eif.viko.lt.mg.universalusappsas.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface FuturamaRepository {
    fun getFuturamaCharacters(): Flow<Resource<List<Futurama>>>
}