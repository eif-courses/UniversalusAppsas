package eif.viko.lt.mg.universalusappsas.domain.repository

import eif.viko.lt.mg.universalusappsas.domain.model.Futurama
import eif.viko.lt.mg.universalusappsas.domain.util.Resource

interface FuturamaRepository {
    suspend fun getFuturamaCharacters(): Resource<List<Futurama>>
}