package eif.viko.lt.mg.universalusappsas.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FuturamaDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insertFuturamaCharacters(characters: List<FuturamaEntity>)

  @Query("SELECT * FROM futuramaentity")
  suspend fun getAllFuturamaCharacters(): List<FuturamaEntity>

}