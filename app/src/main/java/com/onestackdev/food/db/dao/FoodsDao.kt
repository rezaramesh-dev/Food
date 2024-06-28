package com.onestackdev.food.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.onestackdev.food.db.DBHandler
import com.onestackdev.food.db.model.FoodEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodsDao {

    @Insert
    fun insertFood(vararg food: FoodEntity)//when we want pass more than 1 users, we use vararg

    @Query("SELECT * FROM ${DBHandler.FOOD_TABLE} WHERE categoryId = :categoryId")
    fun getFoods(categoryId: Int): Flow<List<FoodEntity>>

    @Query("SELECT * FROM ${DBHandler.FOOD_TABLE} WHERE id = :foodId")
    fun getFoodById(foodId: Int): Flow<FoodEntity>

    @Query("SELECT * FROM ${DBHandler.FOOD_TABLE} WHERE name  LIKE '%' || :foodName || '%'")
    fun searchFoods(foodName: String): Flow<List<FoodEntity>>

}