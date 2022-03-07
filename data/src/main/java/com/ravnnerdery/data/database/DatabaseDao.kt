package com.ravnnerdery.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ravnnerdery.data.database.models.CharacterEntity
import com.ravnnerdery.data.database.models.PreferencesEntity

@Dao
interface DatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacter(character: CharacterEntity)

    @Query("SELECT * FROM characters_table")
    fun getAllCharacters(): List<CharacterEntity>

    @Query("SELECT * FROM characters_table LIMIT :limit OFFSET :key")
    fun getPaginatedCharacters(limit: Int, key: Int): List<CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPreference(pref: PreferencesEntity)

    @Query("SELECT * FROM preferences_table")
    fun getAllPreferences(): List<PreferencesEntity>

    @Query("SELECT COUNT(*) FROM characters_table")
    fun getTablesCount(): Long
}