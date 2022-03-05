package com.ravnnerdery.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ravnnerdery.data.database.models.CharacterEntity

@Dao
interface DatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacter(character: CharacterEntity)

    @Query("SELECT * FROM characters_table ")
    fun getCharacters(): List<CharacterEntity>

    @Query("SELECT * FROM characters_table WHERE groupEndCursor = :key")
    fun getCharactersByPage(key:String): List<CharacterEntity>

    @Query("DELETE FROM characters_table WHERE label != :key")
    fun deleteRemaining(key: String)

    @Query("SELECT * FROM characters_table")
    fun getAllCharacters(): List<CharacterEntity>

}