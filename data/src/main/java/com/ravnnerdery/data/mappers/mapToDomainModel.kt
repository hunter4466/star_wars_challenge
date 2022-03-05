package com.ravnnerdery.data.mappers

import com.ravnnerdery.data.database.models.CharacterEntity
import com.ravnnerdery.domain.models.Character

fun mapToDomainModel(dbItem: CharacterEntity): Character {
    return Character(
        cursor = dbItem.ownCursor,
        groupEndCursor = dbItem.groupEndCursor,
        groupStartCursor = dbItem.groupStartCursor,
        id = dbItem.id,
        name = dbItem.name,
        species = dbItem.specie,
        homeworld = dbItem.homeworld,
        eyeColor = dbItem.eyeColor,
        hairColor = dbItem.hairColor,
        skinColor = dbItem.skinColor,
        birthYear = dbItem.birthYear,
        vehicles = dbItem.vehicles?.map{ it?.name ?: "Undefined" } ?: emptyList()
    )
}