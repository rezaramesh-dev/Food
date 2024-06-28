package com.onestackdev.food.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.onestackdev.food.db.DBHandler.Companion.FOOD_TABLE

@Entity(
    tableName = FOOD_TABLE,
    foreignKeys = [ForeignKey(
        entity = CategoryEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("categoryId"),
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index(value = ["categoryId"])]
)
data class FoodEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val categoryId: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val image: String,
    @ColumnInfo val recipe: String,
    @ColumnInfo val ingredients: Map<String, String>
)