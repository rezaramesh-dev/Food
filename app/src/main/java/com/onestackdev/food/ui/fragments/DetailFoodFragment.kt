package com.onestackdev.food.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.onestackdev.food.mvp.model.ModelDetailFoodFragment
import com.onestackdev.food.mvp.presenter.PresenterDetailFoodFragment
import com.onestackdev.food.mvp.view.ViewDetailFoodFragment

class DetailFoodFragment : Fragment() {

    private lateinit var presenter: PresenterDetailFoodFragment
    private var foodId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments?.isEmpty == false) {
            foodId = arguments?.getInt("foodId")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = ViewDetailFoodFragment(requireContext())

        presenter = PresenterDetailFoodFragment(view, ModelDetailFoodFragment(requireContext()))
        presenter.onCreate()

        sendArg()

        return view.binding.root.rootView

    }

    private fun sendArg() {
        presenter.getArg(foodId)
    }

}