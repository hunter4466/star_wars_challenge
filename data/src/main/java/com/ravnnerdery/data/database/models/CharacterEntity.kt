package com.ravnnerdery.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.ravnnerdery.data.mappers.DomainMapper
import com.ravnnerdery.domain.models.Character
import com.ravnnerdery.starwarschallenge.GetAllPeopleQuery

@Entity(tableName = "characters_table", indices = [Index(value = ["apiId"], unique = true)])
class CharacterEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo
    val cursor: String,
    @ColumnInfo(name="apiId")
    val apiId: String,
    @ColumnInfo
    val name: String,
    @ColumnInfo
    val species: String,
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
    val vehicles: List<String>,
) : DomainMapper<Character> {
    override fun mapToDomainModel(): Character {
        return Character(
            cursor = cursor,
            id = apiId,
            name = name,
            species = species,
            homeworld = homeworld,
            eyeColor = eyeColor,
            hairColor = hairColor,
            skinColor = skinColor,
            birthYear = birthYear,
            vehicles = vehicles.map{it}
        )
    }
}