package eif.viko.lt.mg.universalusappsas.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import eif.viko.lt.mg.universalusappsas.domain.model.Futurama

@Entity
data class FuturamaEntity(
    val Name: String = "",
    val PicUrl: String = "",
    val Profession: String = "",
    @PrimaryKey val id: Int? = null
){
    fun toFuturama(): Futurama {
        return Futurama(
            Name = Name,
            PicUrl = PicUrl,
            Profession = Profession
        )
    }
}
