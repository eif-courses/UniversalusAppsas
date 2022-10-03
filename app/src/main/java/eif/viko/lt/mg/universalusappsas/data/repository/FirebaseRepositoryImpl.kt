package eif.viko.lt.mg.universalusappsas.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.snapshots
import eif.viko.lt.mg.universalusappsas.domain.model.Video
import eif.viko.lt.mg.universalusappsas.domain.repository.FirebaseRepository
import kotlinx.coroutines.channels.awaitClose

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.map

import javax.inject.Inject


class FirebaseRepositoryImpl @Inject constructor(
    private val firebaseFirestore: FirebaseFirestore
) : FirebaseRepository {
    override fun getVideos(): Flow<List<Video>> {
        return firebaseFirestore
            .collection("videos")
            .snapshots()
            .map { it.toObjects(Video::class.java) }
    }
}
//            .map { snapshots ->
//                snapshots.map { it.toUserDto().toUser() }
//            }


//        return firebaseFirestore
//            .collection("videos")
//            .snapshots()
//            .map { querySnapshot -> querySnapshot.toObjects() }
