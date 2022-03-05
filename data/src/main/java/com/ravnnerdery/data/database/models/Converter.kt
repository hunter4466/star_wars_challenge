package com.ravnnerdery.data.database.models

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.ravnnerdery.starwarschallenge.GetAllPeopleQuery

@ProvidedTypeConverter
class Converter {
    @TypeConverter
    fun vehiclesToString(vehicles: List<GetAllPeopleQuery.Vehicle>): String {
        return vehicles.map { it.name }.joinToString(",")
    }

    @TypeConverter
    fun stringToVehicles(stringList: String): List<GetAllPeopleQuery.Vehicle> {
        return stringList.split(",").map {
            GetAllPeopleQuery.Vehicle(name = it)
        }
    }
}