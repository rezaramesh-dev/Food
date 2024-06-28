package com.onestackdev.food.mvp.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.onestackdev.food.R
import com.onestackdev.food.adapters.FoodsRecyclerAdapter
import com.onestackdev.food.databinding.FragmentFoodsBinding
import com.onestackdev.food.databinding.LayoutAddFoodBinding
import com.onestackdev.food.db.model.FoodEntity
import com.onestackdev.food.utils.OnBindData
import com.onestackdev.food.utils.setUpRecyclerGridLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class ViewFoodsFragment(private val context: Context) {

    val binding = FragmentFoodsBinding.inflate(LayoutInflater.from(context))

    private lateinit var foodBinding: LayoutAddFoodBinding
    private lateinit var dialog: BottomSheetDialog

    private lateinit var adapter: FoodsRecyclerAdapter

    fun init() {
        setupRecycler()
        onClickHandler()
    }

    private fun onClickHandler() {
        binding.btnAddFood.setOnClickListener {
            dialog.show()
        }
    }

    fun fetchFoods(data: List<FoodEntity>) {
        CoroutineScope(Main).launch {
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

    fun setCategory(categoryName: String) {
        binding.tvCategory.text = categoryName
    }

    fun setupServerBottomSheet(
        layoutInflater: LayoutInflater,
        categoryId: Int,
        onBindData: OnBindData
    ) {
        foodBinding = LayoutAddFoodBinding.inflate(layoutInflater)
        dialog = BottomSheetDialog(context)
        dialog.setContentView(foodBinding.root)

        dialog.window?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            ?.let { it.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT }

        foodBinding.btnSaveFood.setOnClickListener {
            if (foodBinding.editFoodName.text.isEmpty()) {
                Toast.makeText(context, "Enter Food Name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            onBindData.saveNewFood(
                FoodEntity(
                    0,
                    name = foodBinding.editFoodName.text.toString(),
                    categoryId = categoryId,
                    image = "",
                    recipe = foodBinding.editRecipe.text.toString(),
                    ingredients = mapOf()
                )
            )
            foodBinding.editFoodName.setText("")
            foodBinding.editRecipe.setText("")
            dialog.dismiss()
        }

        foodBinding.btnClose.setOnClickListener { dialog.dismiss() }
    }

    fun updateList(category: List<FoodEntity>) {
        CoroutineScope(Main).launch {
            adapter.dataUpdate(java.util.ArrayList(category))
        }
    }

}