package com.onestackdev.food.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.onestackdev.food.db.DBHandler
import com.onestackdev.food.db.model.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Insert
    fun insertCategory(vararg category: CategoryEntity)//when we want pass more than 1 users, we use vararg

    @Query("SELECT * FROM ${DBHandler.CATEGORY_TABLE}")
    fun getCategory(): Flow<List<CategoryEntity>>

}