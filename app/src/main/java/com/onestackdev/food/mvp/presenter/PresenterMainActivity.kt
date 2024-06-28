package com.onestackdev.food.mvp.presenter

import com.onestackdev.food.mvp.model.ModelMainActivity
import com.onestackdev.food.mvp.view.ViewMainActivity

class PresenterMainActivity(
    private val view: ViewMainActivity, private val model: ModelMainActivity
) {

    fun onCreate() {
        model.setupDatabase()
        view.init()
        view.initBottomNav(model.setupNavigationComponent())
        model.setColorStatusBar()
    }

    fun closeDB() {
        model.closeDB()
    }

}