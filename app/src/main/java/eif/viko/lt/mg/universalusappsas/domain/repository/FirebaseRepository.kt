package eif.viko.lt.mg.universalusappsas.domain.repository

import eif.viko.lt.mg.universalusappsas.domain.model.Video
import kotlinx.coroutines.flow.Flow

interface FirebaseRepository {
    fun getVideos(): Flow<List<Video>>
}