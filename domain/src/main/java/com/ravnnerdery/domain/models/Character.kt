package com.ravnnerdery.domain.models

data class Character(
    val cursor: String,
    val groupEndCursor: String,
    val groupStartCursor: String,
    val id: Long,
    val name: String,
    val species: String,
    val homeworld: String,
    val eyeColor: String,
    val hairColor: String,
    val skinColor: String,
    val birthYear: String,
    val vehicles: List<String>,
)
