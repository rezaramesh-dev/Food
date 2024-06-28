package com.onestackdev.food.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.onestackdev.food.mvp.model.ModelCategoryFragment
import com.onestackdev.food.mvp.presenter.PresenterCategoryFragment
import com.onestackdev.food.mvp.view.ViewCategoryFragment

class CategoriesFragment : Fragment() {

    private lateinit var presenter: PresenterCategoryFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = ViewCategoryFragment(requireContext())

        presenter = PresenterCategoryFragment(view, ModelCategoryFragment(requireContext()))
        presenter.onCreate()

        presenter.setupServerBottomSheet(layoutInflater)

        return view.binding.root.rootView
    }
}