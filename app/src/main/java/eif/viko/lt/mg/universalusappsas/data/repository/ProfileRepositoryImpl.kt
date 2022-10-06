package eif.viko.lt.mg.universalusappsas.data.repository

import com.google.firebase.auth.FirebaseAuth
import eif.viko.lt.mg.universalusappsas.domain.repository.ProfileRepository
import eif.viko.lt.mg.universalusappsas.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
): ProfileRepository {
    override suspend fun signOut(): Flow<Resource<Boolean>> = flow {
        try{
            emit(Resource.Loading())
            auth.currentUser?.apply {
                delete().await()
                emit(Resource.Success(true))
            }
        }catch (e: Exception){
            emit(Resource.Error(e.message?: "ERROR_MESSAGE"))
        }
    }
}