package com.onestackdev.food.mvp.presenter

import com.onestackdev.food.db.model.FoodEntity
import com.onestackdev.food.mvp.model.ModelSearchFoodsFragment
import com.onestackdev.food.mvp.view.ViewSearchFoodsFragment
import com.onestackdev.food.utils.OnBindData

class PresenterSearchFoodsFragment(
    private val view: ViewSearchFoodsFragment, private val model: ModelSearchFoodsFragment
) {

    fun onCreate() {
        view.init()
        searchHandler()
    }

    private fun searchHandler() {
        view.searchHandler(object : OnBindData {
            override fun searchFood(foodName: String) {
                model.getFoods(foodName, object : OnBindData {
                    override fun searchResult(foods: List<FoodEntity>) {
                        view.fetchFoods(foods)
                    }
                })
            }
        })
    }

}