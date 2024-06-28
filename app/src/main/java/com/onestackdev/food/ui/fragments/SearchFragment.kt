package com.onestackdev.food.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.onestackdev.food.mvp.model.ModelSearchFoodsFragment
import com.onestackdev.food.mvp.presenter.PresenterSearchFoodsFragment
import com.onestackdev.food.mvp.view.ViewSearchFoodsFragment

class SearchFragment : Fragment() {

    private lateinit var presenter: PresenterSearchFoodsFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = ViewSearchFoodsFragment(requireContext())

        presenter = PresenterSearchFoodsFragment(view, ModelSearchFoodsFragment(requireContext()))
        presenter.onCreate()

        return view.binding.root.rootView
    }
}