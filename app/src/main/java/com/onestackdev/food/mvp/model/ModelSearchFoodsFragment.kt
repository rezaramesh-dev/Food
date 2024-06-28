package com.onestackdev.food.mvp.model

import android.content.Context
import com.onestackdev.food.db.DBHandler
import com.onestackdev.food.utils.OnBindData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ModelSearchFoodsFragment(private val context: Context) {

    private val db = DBHandler.getDatabase(context)

    fun getFoods(foodName: String, onBindData: OnBindData) {
        CoroutineScope(IO).launch {
            db.foodsDao().searchFoods(foodName).collect { foods ->
                onBindData.searchResult(foods)
            }
        }
    }

}