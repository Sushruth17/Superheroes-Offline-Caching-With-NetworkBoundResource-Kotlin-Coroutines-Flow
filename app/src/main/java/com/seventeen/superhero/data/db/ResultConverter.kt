package com.seventeen.superhero.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.seventeen.superhero.data.ResultsItem
import java.util.*


class ResultConverter {
    private val gson = Gson()
    @TypeConverter
    fun stringToList(data: String?): List<ResultsItem> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<ResultsItem>>() {

        }.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun listToString(someObjects: List<ResultsItem>): String {
        return gson.toJson(someObjects)
    }
}