package eif.viko.lt.mg.universalusappsas.presentation.ui.youtubevideos

import eif.viko.lt.mg.universalusappsas.domain.model.Video

data class YoutubeVideoState(
    val videos: List<Video> = emptyList()
)