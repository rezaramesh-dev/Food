package com.onestackdev.food.db.extension

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.onestackdev.food.db.model.FoodEntity

class Converters {

    @TypeConverter
    fun fromFoodsList(value: List<FoodEntity>): String {
        val gson = Gson()
        val type = object : TypeToken<List<FoodEntity>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toFoodsList(value: String): List<FoodEntity> {
        val gson = Gson()
        val type = object : TypeToken<List<FoodEntity>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromIngredientsList(value: List<Map<String, String>>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Map<String, String>>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toIngredientsList(value: String): List<Map<String, String>> {
        val gson = Gson()
        val type = object : TypeToken<List<Map<String, String>>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromString(value: String): Map<String, String> {
        val mapType = object : TypeToken<Map<String, String>>() {}.type
        return Gson().fromJson(value, mapType)
    }

    @TypeConverter
    fun fromMap(map: Map<String, String>): String {
        return Gson().toJson(map)
    }

}