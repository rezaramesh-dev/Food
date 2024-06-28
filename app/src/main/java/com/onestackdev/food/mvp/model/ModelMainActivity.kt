package com.onestackdev.food.mvp.model

import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.onestackdev.food.R
import com.onestackdev.food.db.DBHandler
import com.onestackdev.food.db.extension.generateCategoryList
import com.onestackdev.food.db.extension.generateFoodsList
import com.onestackdev.food.utils.AppConfigManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ModelMainActivity(private val context: AppCompatActivity) {

    private lateinit var navHost: NavHostFragment

    private lateinit var db: DBHandler

    fun setColorStatusBar() {
        val window = context.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(context, R.color.yellow)
    }

    fun setupNavigationComponent(): NavController {
        navHost = context.supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        return navHost.navController
    }

    fun setupDatabase() {
        db = DBHandler.getDatabase(context)
        if (AppConfigManager.getAppStatus(context)) {
            AppConfigManager.openFirstTime(context, false)
            CoroutineScope(IO).launch {
                generateCategoryList().forEach { category ->
                    db.categoryDao().insertCategory(category)
                }
                generateFoodsList().forEach { foods ->
                    db.foodsDao().insertFood(foods)
                }
            }
        }
    }

    fun closeDB() {
        db.close()
    }

}