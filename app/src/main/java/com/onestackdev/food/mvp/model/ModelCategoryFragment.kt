package com.onestackdev.food.mvp.model

import android.content.Context
import com.onestackdev.food.db.DBHandler
import com.onestackdev.food.db.model.CategoryEntity
import com.onestackdev.food.utils.OnBindData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ModelCategoryFragment(private val context: Context) {

    private val db = DBHandler.getDatabase(context)

    fun getCategory(onBindData: OnBindData) {
        CoroutineScope(IO).launch {
            db.categoryDao().getCategory().collect { categories ->
                onBindData.fetchCategory(categories)
            }
        }
    }

    fun saveNewCategory(category: CategoryEntity, onBindData: OnBindData) {
        CoroutineScope(IO).launch {
            db.categoryDao().insertCategory(category)
            db.categoryDao().getCategory().collect {
                onBindData.updateCategory(it)
            }
        }
    }

}