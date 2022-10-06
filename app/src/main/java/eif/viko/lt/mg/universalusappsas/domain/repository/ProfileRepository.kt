package eif.viko.lt.mg.universalusappsas.domain.repository

import eif.viko.lt.mg.universalusappsas.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    suspend fun signOut(): Flow<Resource<Boolean>>
}