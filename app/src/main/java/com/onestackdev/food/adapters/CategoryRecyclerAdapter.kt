package com.onestackdev.food.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.onestackdev.food.R
import com.onestackdev.food.databinding.CategoryListItemsBinding
import com.onestackdev.food.db.model.CategoryEntity
import com.onestackdev.food.utils.OnBindData

class CategoryRecyclerAdapter(
    private val dataList: ArrayList<CategoryEntity>,
    private val context: Context,
    private val onBindData: OnBindData
) : RecyclerView.Adapter<CategoryRecyclerAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            CategoryListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) =
        holder.setData(dataList[position])

    override fun getItemCount(): Int = dataList.size

    inner class ListViewHolder(private val binding: CategoryListItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(data: CategoryEntity) {
            data.apply {
                Glide.with(context).load(image)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(binding.imageCategory)

                binding.tvCategory.text = name

                itemView.setOnClickListener {
                    onBindData.showCategoryFoods(id, categoryName)
                }
            }
        }
    }

    fun dataUpdate(newList: ArrayList<CategoryEntity>) {
        val diffCallback = RecyclerDiffUtils(oldList = dataList, newList = newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        dataList.clear()
        dataList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }
}