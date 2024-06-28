package com.onestackdev.food.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.onestackdev.food.db.DBHandler.Companion.CATEGORY_TABLE

@Entity(tableName = CATEGORY_TABLE)
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo val categoryName: String,
    @ColumnInfo val name: String,
    @ColumnInfo val image: String
)
