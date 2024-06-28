package com.onestackdev.food.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.onestackdev.food.db.dao.CategoryDao
import com.onestackdev.food.db.dao.FoodsDao
import com.onestackdev.food.db.extension.Converters
import com.onestackdev.food.db.model.CategoryEntity
import com.onestackdev.food.db.model.FoodEntity

@Database(
    entities = [CategoryEntity::class, FoodEntity::class],
    version = DBHandler.DATABASE_VERSION, exportSchema = false
)
@TypeConverters(Converters::class)
abstract class DBHandler : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
    abstract fun foodsDao(): FoodsDao

    companion object {
        const val CATEGORY_TABLE = "CategoryTable"
        const val FOOD_TABLE = "FoodTable"
        private const val DATABASE_NAME = "database"
        const val DATABASE_VERSION = 1

        private var INSTANCE: DBHandler? = null
        fun getDatabase(context: Context): DBHandler {
            if (INSTANCE == null)
                INSTANCE = Room.databaseBuilder(context, DBHandler::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration().build()
            return INSTANCE!!
        }
    }
}