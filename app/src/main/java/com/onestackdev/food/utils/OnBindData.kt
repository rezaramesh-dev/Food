package com.onestackdev.food.utils

import com.onestackdev.food.db.model.CategoryEntity
import com.onestackdev.food.db.model.FoodEntity

interface OnBindData {

    fun fetchCategory(data: List<CategoryEntity>) {}

    fun fetchFoods(data: List<FoodEntity>) {}

    fun showCategoryFoods(id: Int, categoryName: String) {}

    fun showDetailFood(id: Int) {}

    fun fetchRecipeData(food: FoodEntity) {}

    fun saveNewCategory(category: CategoryEntity) {}

    fun updateCategory(category: List<CategoryEntity>) {}

    fun saveNewFood(food: FoodEntity) {}

    fun updateFoods(foods: List<FoodEntity>) {}

    fun searchFood(foodName: String) {}

    fun searchResult(foods: List<FoodEntity>) {}

}