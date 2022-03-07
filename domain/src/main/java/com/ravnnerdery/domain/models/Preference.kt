package com.ravnnerdery.domain.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class Preference (
    val id: Long = 0,
    val apiId: String,
    val preference: Boolean
)