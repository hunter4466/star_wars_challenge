package com.ravnnerdery.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ravnnerdery.data.database.models.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1, exportSchema = false)
abstract class StarWarsDataBase : RoomDatabase(){
    abstract fun databaseDao(): DatabaseDao
}
