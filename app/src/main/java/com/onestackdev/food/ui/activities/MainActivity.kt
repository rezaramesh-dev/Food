package com.onestackdev.food.ui.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.onestackdev.food.mvp.model.ModelMainActivity
import com.onestackdev.food.mvp.presenter.PresenterMainActivity
import com.onestackdev.food.mvp.view.ViewMainActivity

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: PresenterMainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val view = ViewMainActivity(this)
        setContentView(view.binding.root)

        presenter = PresenterMainActivity(view, ModelMainActivity(this))
        presenter.onCreate()
    }

    override fun onDestroy() {
        presenter.closeDB()
        super.onDestroy()
    }
}