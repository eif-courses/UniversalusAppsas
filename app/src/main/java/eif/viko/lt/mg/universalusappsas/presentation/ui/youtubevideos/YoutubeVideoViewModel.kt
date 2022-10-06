package eif.viko.lt.mg.universalusappsas.presentation.ui.youtubevideos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eif.viko.lt.mg.universalusappsas.domain.use_case.firestore_use_case.GetYoutubeVideosUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class YoutubeVideoViewModel @Inject constructor(
    private val getYoutubeVideosUseCase: GetYoutubeVideosUseCase
) : ViewModel() {

    var state by mutableStateOf(YoutubeVideoState())
    private set


    init{
        getYoutubeVideos()
    }

    private fun getYoutubeVideos(){
        getYoutubeVideosUseCase().onEach {
            state = state.copy(videos = it)
        }.launchIn(viewModelScope)
    }




}