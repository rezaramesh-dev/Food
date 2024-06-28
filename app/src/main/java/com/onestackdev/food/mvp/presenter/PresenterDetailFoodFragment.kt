package com.onestackdev.food.mvp.presenter

import com.onestackdev.food.db.model.FoodEntity
import com.onestackdev.food.mvp.model.ModelDetailFoodFragment
import com.onestackdev.food.mvp.view.ViewDetailFoodFragment
import com.onestackdev.food.utils.OnBindData

class PresenterDetailFoodFragment(
    private val view: ViewDetailFoodFragment, private val model: ModelDetailFoodFragment
) {

    fun getArg(foodId: Int) {
        model.getFoodById(foodId, onBindData = object : OnBindData {
            override fun fetchRecipeData(food: FoodEntity) {
                view.fetchFoods(food)
            }
        })
    }

    fun onCreate() {
        view.init()
    }

}