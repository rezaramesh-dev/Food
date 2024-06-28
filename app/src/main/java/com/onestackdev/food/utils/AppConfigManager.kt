package com.onestackdev.food.utils

import android.content.Context
import android.content.SharedPreferences

object AppConfigManager {

    private const val APP_CONFIG_MANAGER = "user_manager"

    fun openFirstTime(context: Context, isFirst: Boolean) {
        val pref: SharedPreferences =
            context.getSharedPreferences(APP_CONFIG_MANAGER, Context.MODE_PRIVATE)

        with(pref.edit()) {
            putBoolean("isFirst", isFirst)
            apply()
        }
    }

    fun getAppStatus(context: Context): Boolean {
        val pref: SharedPreferences =
            context.getSharedPreferences(APP_CONFIG_MANAGER, Context.MODE_PRIVATE)
        return pref.getBoolean("isFirst", true)
    }

    fun clearApp(context: Context) {
        val pref: SharedPreferences =
            context.getSharedPreferences(APP_CONFIG_MANAGER, Context.MODE_PRIVATE)
        pref.edit().clear().apply()
    }
}
