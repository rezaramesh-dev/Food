package com.onestackdev.food.mvp.model

import android.content.Context
import com.onestackdev.food.db.DBHandler
import com.onestackdev.food.utils.OnBindData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ModelDetailFoodFragment(private val context: Context) {

    private val db = DBHandler.getDatabase(context)

    fun getFoodById(foodId: Int, onBindData: OnBindData) {
        CoroutineScope(IO).launch {
            db.foodsDao().getFoodById(foodId).collect { food ->
                onBindData.fetchRecipeData(food)
            }
        }
    }

}