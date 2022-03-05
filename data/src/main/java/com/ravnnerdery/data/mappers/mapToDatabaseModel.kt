package com.ravnnerdery.data.mappers

import androidx.room.ColumnInfo
import com.ravnnerdery.data.database.models.CharacterEntity
import com.ravnnerdery.starwarschallenge.GetAllPeopleQuery

fun mapToDatabaseModel(
    response: GetAllPeopleQuery.Edge?,
    label: String,
    hasNextPage: Boolean,
    hasPreviousPage: Boolean,
    groupStartCursor: String,
    groupEndCursor: String,
): CharacterEntity {
    return CharacterEntity(
        groupStartCursor = groupStartCursor,
        groupEndCursor = groupEndCursor,
        ownCursor = response?.cursor ?: "Undefined",
        label = label,
        edgeId = response?.node?.id ?: "Undefined",
        hasNextPage = hasNextPage,
        hasPreviousPage = hasPreviousPage,
        name = response?.node?.name ?: "Undefined",
        specie = response?.node?.species?.name ?: "Undefined",
        homeworld = response?.node?.homeworld?.name ?: "Undefined",
        eyeColor = response?.node?.eyeColor ?: "Undefined",
        hairColor = response?.node?.hairColor ?: "Undefined",
        skinColor = response?.node?.skinColor ?: "Undefined",
        birthYear = response?.node?.birthYear ?: "Undefined",
        vehicles = response?.node?.vehicleConnection?.vehicles?.map { GetAllPeopleQuery.Vehicle(it?.name) } ?: emptyList() , //List<GetAllPeopleQuery.Vehicle?>?,
    )
}
