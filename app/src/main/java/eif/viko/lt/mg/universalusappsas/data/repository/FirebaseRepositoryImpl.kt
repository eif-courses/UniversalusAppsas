package eif.viko.lt.mg.universalusappsas.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.snapshots
import eif.viko.lt.mg.universalusappsas.domain.model.Video
import eif.viko.lt.mg.universalusappsas.domain.repository.FirebaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FirebaseRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : FirebaseRepository{
    override fun getVideos(): Flow<List<Video>> {
        return firestore
            .collection("videos")
            .snapshots()
            .map { it.toObjects(Video::class.java) }
    }
}