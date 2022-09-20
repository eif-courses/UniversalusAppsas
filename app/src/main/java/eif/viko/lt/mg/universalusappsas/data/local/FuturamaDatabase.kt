package eif.viko.lt.mg.universalusappsas.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [FuturamaEntity::class],
    version = 1
)
abstract class FuturamaDatabase : RoomDatabase(){
    abstract val dao: FuturamaDao
}