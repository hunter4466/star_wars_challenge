package com.ravnnerdery.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ravnnerdery.data.database.models.CharacterEntity
import com.ravnnerdery.data.database.models.Converter
import com.ravnnerdery.data.database.models.PreferencesEntity

@Database(entities = [CharacterEntity::class,PreferencesEntity::class], version = 14, exportSchema = false)
@TypeConverters(Converter::class)
abstract class StarWarsDataBase : RoomDatabase(){
    abstract fun databaseDao(): DatabaseDao
}
