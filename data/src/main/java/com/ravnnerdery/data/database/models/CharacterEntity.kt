package com.ravnnerdery.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.ravnnerdery.data.mappers.DomainMapper
import com.ravnnerdery.domain.models.Character

@Entity(tableName = "characters_table", indices = [Index(value = ["apiId"], unique = true)])
class CharacterEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo
    val cursor: String,
    @ColumnInfo(name = "apiId")
    val edgeId: String,
    @ColumnInfo
    val name: String,
    @ColumnInfo
    val specie: String,
    @ColumnInfo
    val homeworld: String,
    @ColumnInfo
    val eyeColor: String,
    @ColumnInfo
    val hairColor: String,
    @ColumnInfo
    val skinColor: String,
    @ColumnInfo
    val birthYear: String,
    @ColumnInfo
    val vehicles: String
) : DomainMapper<Character> {
    override fun mapToDomainModel(): Character = Character(
        id,
        cursor,
        edgeId,
        name,
        specie,
        homeworld,
        eyeColor,
        hairColor,
        skinColor,
        birthYear,
        vehicles.split(",")
    )
}