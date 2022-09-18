package eif.viko.lt.mg.universalusappsas.data.remote

import eif.viko.lt.mg.universalusappsas.domain.model.Futurama

data class FuturamaDto(
    val Age: String,
    val FirstAppearance: String,
    val Name: String,
    val PicUrl: String,
    val Planet: String,
    val Profession: String,
    val Relatives: String,
    val Species: String,
    val Status: String,
    val VoicedBy: String
){
    fun toFuturama(): Futurama {
        return Futurama(
            Name = Name,
            PicUrl = PicUrl,
            Profession = Profession
        )
    }
}

