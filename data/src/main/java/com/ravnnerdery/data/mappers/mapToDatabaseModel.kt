package com.ravnnerdery.data.mappers

import com.ravnnerdery.data.database.models.CharacterEntity
import com.ravnnerdery.starwarschallenge.GetAllPeopleQuery

fun mapToDatabaseModel(edge: GetAllPeopleQuery.Edge?): CharacterEntity {
    val stringedVehicles = mutableListOf<String>()
    edge?.node?.vehicleConnection?.vehicles?.forEach { vehicle ->
        vehicle?.let {
            it.name?.let { it1 -> stringedVehicles.add(it1) }
        }
    }
    return CharacterEntity(
        cursor = edge?.cursor ?: "Undefined",
        edgeId = edge?.node?.id ?: "Undefined",
        name = edge?.node?.name ?: "Undefined",
        specie = edge?.node?.species?.name ?: "Undefined",
        homeworld = edge?.node?.homeworld?.name ?: "Undefined",
        eyeColor = edge?.node?.eyeColor ?: "Undefined",
        hairColor = edge?.node?.hairColor ?: "Undefined",
        skinColor = edge?.node?.skinColor ?: "Undefined",
        birthYear = edge?.node?.birthYear ?: "Undefined",
        vehicles = stringedVehicles.joinToString(separator = ",")
    )
}
