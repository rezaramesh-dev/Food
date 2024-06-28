package com.onestackdev.food.mvp.presenter

import android.view.LayoutInflater
import com.onestackdev.food.db.model.FoodEntity
import com.onestackdev.food.mvp.model.ModelFoodsFragment
import com.onestackdev.food.mvp.view.ViewFoodsFragment
import com.onestackdev.food.utils.OnBindData

class PresenterFoodsFragment(
    private val view: ViewFoodsFragment, private val model: ModelFoodsFragment
) {

    fun getArg(categoryId: Int, categoryName: String) {
        view.setCategory(categoryName)
        model.getFoods(categoryId, onBindData = object : OnBindData {
            override fun fetchFoods(data: List<FoodEntity>) {
                view.fetchFoods(data)
            }
        })
    }

    fun onCreate() {
        view.init()
    }

    fun setupServerBottomSheet(inflater: LayoutInflater, categoryId: Int) {
        view.setupServerBottomSheet(inflater, categoryId, object : OnBindData {
            override fun saveNewFood(food: FoodEntity) {
                model.saveNewFood(food, categoryId, object : OnBindData {
                    override fun updateFoods(foods: List<FoodEntity>) {
                        view.updateList(foods)
                    }
                })
            }
        })
    }

}