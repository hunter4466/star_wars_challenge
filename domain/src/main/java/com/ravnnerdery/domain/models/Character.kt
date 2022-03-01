package com.ravnnerdery.domain.models

data class Character(
    val id: Long = 0,
    val cursor: String,
    val edgeId: String,
    val name: String,
    val specie: String,
    val homeworld: String,
    val eyeColor: String,
    val hairColor: String,
    val skinColor: String,
    val birthYear: String,
    val vehicles: List<String>
)