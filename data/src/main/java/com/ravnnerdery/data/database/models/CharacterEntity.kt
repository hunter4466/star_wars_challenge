package com.ravnnerdery.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.ravnnerdery.starwarschallenge.GetAllPeopleQuery

@Entity(tableName = "characters_table", indices = [Index(value = ["apiId"], unique = true)])
class CharacterEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo
    val groupStartCursor: String,
    @ColumnInfo
    val groupEndCursor: String,
    @ColumnInfo
    val ownCursor: String,
    @ColumnInfo
    val label: String,
    @ColumnInfo(name = "apiId")
    val edgeId: String,
    @ColumnInfo
    val hasNextPage: Boolean,
    @ColumnInfo
    val hasPreviousPage: Boolean,
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
    val vehicles: List<GetAllPeopleQuery.Vehicle>,
)