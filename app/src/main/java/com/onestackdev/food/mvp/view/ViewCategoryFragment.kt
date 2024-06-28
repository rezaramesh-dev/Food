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
import com.onestackdev.food.adapters.CategoryRecyclerAdapter
import com.onestackdev.food.databinding.FragmentCategoriesBinding
import com.onestackdev.food.databinding.LayoutAddCategoryBinding
import com.onestackdev.food.db.model.CategoryEntity
import com.onestackdev.food.utils.OnBindData
import com.onestackdev.food.utils.setUpRecyclerLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class ViewCategoryFragment(private val context: Context) {

    val binding = FragmentCategoriesBinding.inflate(LayoutInflater.from(context))

    private lateinit var categoryBinding: LayoutAddCategoryBinding
    private lateinit var dialog: BottomSheetDialog

    private lateinit var adapter: CategoryRecyclerAdapter

    fun init() {
        setupRecycler()
        onClickHandler()
    }

    private fun onClickHandler() {
        binding.btnAddCategory.setOnClickListener {
            dialog.show()
        }
    }

    fun fetchCategory(data: List<CategoryEntity>) {
        CoroutineScope(Main).launch {
            adapter =
                CategoryRecyclerAdapter(ArrayList(data), context, onBindData = object : OnBindData {
                    override fun showCategoryFoods(id: Int, categoryName: String) {
                        val bundle = Bundle().apply {
                            putInt("categoryId", id)
                            putString("categoryName", categoryName)
                        }
                        binding.root.findNavController().navigate(R.id.foodsFragment, args = bundle)
                    }
                })
            binding.rvCategory.adapter = adapter
        }
    }

    private fun setupRecycler() {
        setUpRecyclerLayoutManager(
            context, binding.rvCategory, isVertical = true, isReverse = false
        )
    }

    fun setupServerBottomSheet(layoutInflater: LayoutInflater, onBindData: OnBindData) {
        categoryBinding = LayoutAddCategoryBinding.inflate(layoutInflater)
        dialog = BottomSheetDialog(context)
        dialog.setContentView(categoryBinding.root)

        dialog.window?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            ?.let { it.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT }


        categoryBinding.btnSaveCategory.setOnClickListener {
            if (categoryBinding.editCategoryName.text.isEmpty()) {
                Toast.makeText(context, "Enter Category Name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            onBindData.saveNewCategory(
                CategoryEntity(
                    0, categoryName = categoryBinding.editCategoryName.text.toString(),
                    name = categoryBinding.editCategoryName.text.toString(), image = ""
                )
            )
            categoryBinding.editCategoryName.setText("")
            dialog.dismiss()
        }

        categoryBinding.btnClose.setOnClickListener { dialog.dismiss() }
    }

    fun updateList(category: List<CategoryEntity>) {
        CoroutineScope(Main).launch {
            adapter.dataUpdate(ArrayList(category))
        }
    }

}