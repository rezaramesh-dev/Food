package com.onestackdev.food.mvp.view

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.inputmethod.EditorInfo
import androidx.navigation.findNavController
import com.onestackdev.food.R
import com.onestackdev.food.adapters.FoodsRecyclerAdapter
import com.onestackdev.food.databinding.FragmentSearchBinding
import com.onestackdev.food.db.model.FoodEntity
import com.onestackdev.food.utils.OnBindData
import com.onestackdev.food.utils.setUpRecyclerGridLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class ViewSearchFoodsFragment(private val context: Context) {

    val binding = FragmentSearchBinding.inflate(LayoutInflater.from(context))

    private lateinit var adapter: FoodsRecyclerAdapter

    fun init() {
        setupRecycler()
    }

    fun fetchFoods(data: List<FoodEntity>) {
        CoroutineScope(Main).launch {
            binding.rvFoods.adapter = null
            adapter =
                FoodsRecyclerAdapter(ArrayList(data), context, onBindData = object : OnBindData {
                    override fun showDetailFood(id: Int) {
                        val bundle = Bundle().apply {
                            putInt("foodId", id)
                        }
                        binding.root.findNavController()
                            .navigate(R.id.detailFoodFragment, args = bundle)
                    }
                })
            binding.rvFoods.adapter = adapter
        }
    }

    private fun setupRecycler() {
        setUpRecyclerGridLayout(
            context, binding.rvFoods, isVertical = true, isReverse = false
        )
    }

    fun searchHandler(onBindData: OnBindData) {
        CoroutineScope(Main).launch {
            binding.searchFood.setOnEditorActionListener { v, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH || event?.action == KeyEvent.ACTION_DOWN && event.keyCode == KeyEvent.KEYCODE_ENTER) {
                    val query = binding.searchFood.text.toString()
                    if (query.isNotEmpty()) {
                        onBindData.searchFood(query)
                    }
                    true
                } else {
                    false
                }
            }
        }
    }

}