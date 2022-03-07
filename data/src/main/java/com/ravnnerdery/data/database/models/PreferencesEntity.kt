package com.ravnnerdery.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.ravnnerdery.data.mappers.DomainMapper
import com.ravnnerdery.domain.models.Preference

@Entity(tableName = "preferences_table", indices = [Index(value = ["apiId"], unique = true)])
data class PreferencesEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name="apiId")
    val apiId: String,
    @ColumnInfo
    val preference: Boolean
): DomainMapper <Preference>{
    override fun mapToDomainModel(): Preference {
        return Preference(id, apiId, preference)
    }
}