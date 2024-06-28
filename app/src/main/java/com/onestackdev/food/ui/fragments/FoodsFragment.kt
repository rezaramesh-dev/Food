package com.onestackdev.food.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.onestackdev.food.mvp.model.ModelFoodsFragment
import com.onestackdev.food.mvp.presenter.PresenterFoodsFragment
import com.onestackdev.food.mvp.view.ViewFoodsFragment

class FoodsFragment : Fragment() {

    private lateinit var presenter: PresenterFoodsFragment
    private var categoryId = 0
    private var categoryName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments?.isEmpty == false) {
            categoryId = arguments?.getInt("categoryId")!!
            categoryName = arguments?.getString("categoryName").toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = ViewFoodsFragment(requireContext())

        presenter = PresenterFoodsFragment(view, ModelFoodsFragment(requireContext()))
        presenter.onCreate()

        sendArg()

        presenter.setupServerBottomSheet(layoutInflater, categoryId)

        return view.binding.root.rootView
    }

    private fun sendArg() {
        presenter.getArg(categoryId = categoryId, categoryName = categoryName)
    }
}