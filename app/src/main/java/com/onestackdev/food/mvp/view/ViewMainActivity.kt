package com.onestackdev.food.mvp.view

import android.content.Context
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import com.onestackdev.food.databinding.ActivityMainBinding

class ViewMainActivity(private val context: Context) {

    val binding = ActivityMainBinding.inflate(LayoutInflater.from(context))

    fun init() {
        //
    }

    fun initBottomNav(navController: NavController) {
        binding.bottomNavMain.setupWithNavController(navController)
    }

}