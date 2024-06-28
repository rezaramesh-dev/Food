package com.onestackdev.food.mvp.presenter

import android.view.LayoutInflater
import com.onestackdev.food.db.model.CategoryEntity
import com.onestackdev.food.mvp.model.ModelCategoryFragment
import com.onestackdev.food.mvp.view.ViewCategoryFragment
import com.onestackdev.food.utils.OnBindData

class PresenterCategoryFragment(
    private val view: ViewCategoryFragment, private val model: ModelCategoryFragment
) {

    fun onCreate() {
        view.init()
        model.getCategory(object : OnBindData {
            override fun fetchCategory(data: List<CategoryEntity>) {
                view.fetchCategory(data)
            }
        })
    }

    fun setupServerBottomSheet(inflater: LayoutInflater) {
        view.setupServerBottomSheet(inflater, object : OnBindData {
            override fun saveNewCategory(category: CategoryEntity) {
                model.saveNewCategory(category, object : OnBindData {
                    override fun updateCategory(category: List<CategoryEntity>) {
                        view.updateList(category)
                    }
                })
            }
        })
    }

}