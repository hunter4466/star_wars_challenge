package com.ravnnerdery.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ravnnerdery.data.database.models.CharacterEntity

@Dao
interface DatabaseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCharacter(character: CharacterEntity)

    @Query("SELECT * FROM characters_table")
    fun getCharacters(): List<CharacterEntity>
}