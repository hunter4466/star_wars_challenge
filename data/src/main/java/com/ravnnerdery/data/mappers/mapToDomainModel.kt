package com.ravnnerdery.data.mappers

import com.ravnnerdery.domain.models.Character
import com.ravnnerdery.starwarschallenge.GetAllPeopleQuery

fun mapToDomainModel(networkItem: GetAllPeopleQuery.Edge?): Character {
    return Character(
        cursor = networkItem?.cursor ?: "Undefined",
        id = networkItem?.node?.id ?: "Undefined",
        name = networkItem?.node?.name ?: "Undefined",
        species = networkItem?.node?.species?.name ?: "Undefined",
        homeworld = networkItem?.node?.homeworld?.name ?: "Undefined",
        eyeColor = networkItem?.node?.eyeColor ?: "Undefined",
        hairColor = networkItem?.node?.hairColor ?: "Undefined",
        skinColor = networkItem?.node?.skinColor ?: "Undefined",
        birthYear = networkItem?.node?.birthYear ?: "Undefined",
        vehicles = networkItem?.node?.vehicleConnection?.vehicles?.map{ it?.name ?: "Undefined" } ?: emptyList()
    )
}