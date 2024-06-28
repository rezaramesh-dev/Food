package com.onestackdev.food.mvp.view

import android.content.Context
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.onestackdev.food.R
import com.onestackdev.food.adapters.IngredientsRecyclerAdapter
import com.onestackdev.food.databinding.FragmentDetailFoodBinding
import com.onestackdev.food.db.model.FoodEntity
import com.onestackdev.food.utils.setUpRecyclerLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class ViewDetailFoodFragment(private val context: Context) {

    val binding = FragmentDetailFoodBinding.inflate(LayoutInflater.from(context))

    fun init() {
        setupRecycler()
    }

    fun fetchFoods(data: FoodEntity) {
        CoroutineScope(Main).launch {
            data.apply {
                binding.tvFoodName.text = name
                binding.tvRecipe.text = recipe

                Glide.with(context).load(image)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(binding.imageFood)


                val adapter = IngredientsRecyclerAdapter(ingredients, context)
                binding.rvIngredients.adapter = adapter
            }
        }
    }

    private fun setupRecycler() {
        setUpRecyclerLayoutManager(
            context, binding.rvIngredients, isVertical = true, isReverse = false
        )
    }
}