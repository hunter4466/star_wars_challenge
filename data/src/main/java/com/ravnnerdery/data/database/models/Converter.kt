package com.ravnnerdery.data.database.models

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.ravnnerdery.starwarschallenge.GetAllPeopleQuery

@ProvidedTypeConverter
class Converter {
    @TypeConverter
    fun vehiclesToString(vehicles: List<String>): String {
        return vehicles.joinToString(",")
    }

    @TypeConverter
    fun stringToVehicles(stringList: String): List<String> {
        return stringList.split(",").map { it }
    }
}