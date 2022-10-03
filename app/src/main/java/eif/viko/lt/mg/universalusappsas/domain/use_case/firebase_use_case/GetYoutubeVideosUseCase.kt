package eif.viko.lt.mg.universalusappsas.domain.use_case.firebase_use_case

import eif.viko.lt.mg.universalusappsas.domain.model.Video
import eif.viko.lt.mg.universalusappsas.domain.repository.FirebaseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetYoutubeVideosUseCase @Inject constructor(
    private val repository: FirebaseRepository
) {
    operator fun invoke(): Flow<List<Video>> {
        return repository.getVideos()
    }
}
