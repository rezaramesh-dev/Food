package com.onestackdev.food.mvp.model

import android.content.Context
import com.onestackdev.food.db.DBHandler
import com.onestackdev.food.db.model.FoodEntity
import com.onestackdev.food.utils.OnBindData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ModelFoodsFragment(private val context: Context) {

    private val db = DBHandler.getDatabase(context)

    fun getFoods(categoryId: Int, onBindData: OnBindData) {
        CoroutineScope(IO).launch {
            db.foodsDao().getFoods(categoryId).collect { categories ->
                onBindData.fetchFoods(categories)
            }
        }
    }

    fun saveNewFood(food: FoodEntity, categoryId: Int, onBindData: OnBindData) {
        CoroutineScope(IO).launch {
            db.foodsDao().insertFood(food)
            db.foodsDao().getFoods(categoryId).collect {
                onBindData.updateFoods(it)
            }
        }
    }

}