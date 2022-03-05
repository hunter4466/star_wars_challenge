package com.ravnnerdery.data.mappers

import androidx.room.ColumnInfo
import com.ravnnerdery.data.database.models.CharacterEntity
import com.ravnnerdery.domain.models.Character
import com.ravnnerdery.starwarschallenge.GetAllPeopleQuery

fun mapToDatabaseModel(
    character: Character
): CharacterEntity {
    return CharacterEntity(
        apiId = character.id,
        cursor = character.cursor,
        name = character.name,
        species = character.species,
        homeworld = character.homeworld,
        eyeColor = character.eyeColor,
        hairColor = character.hairColor,
        skinColor = character.skinColor,
        birthYear = character.birthYear,
        vehicles = character.vehicles, //List<GetAllPeopleQuery.Vehicle?>?,
    )
}
