package eif.viko.lt.mg.universalusappsas.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import eif.viko.lt.mg.universalusappsas.domain.repository.FirebaseAuthRepository
import eif.viko.lt.mg.universalusappsas.domain.util.Resource
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
) :FirebaseAuthRepository {

    override fun isUserAuthenticatedInFirebase(): Boolean {
        return  auth.currentUser != null
    }

    override suspend fun firebaseSignInAnonymously(): Flow<Resource<Boolean>> = flow{
        try{
            emit(Resource.Loading())
            auth.signInAnonymously().await()
            emit(Resource.Success(true))
        }catch (e: Exception){
            emit(Resource.Error(e.message?: "ERROR_MESSAGE"))
        }
    }

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

    override fun getFirebaseAuthState(): Flow<Boolean> = callbackFlow{
        val authStateListener = FirebaseAuth.AuthStateListener {
            trySend(it.currentUser == null)
        }
        auth.addAuthStateListener(authStateListener)
        awaitClose{
            auth.removeAuthStateListener(authStateListener)
        }
    }

}