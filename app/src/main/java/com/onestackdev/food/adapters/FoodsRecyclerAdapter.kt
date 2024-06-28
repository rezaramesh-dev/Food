package com.onestackdev.food.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.onestackdev.food.R
import com.onestackdev.food.databinding.FoodsListItemsBinding
import com.onestackdev.food.db.model.FoodEntity
import com.onestackdev.food.utils.OnBindData

class FoodsRecyclerAdapter(
    private val dataList: ArrayList<FoodEntity>,
    private val context: Context,
    private val onBindData: OnBindData
) : RecyclerView.Adapter<FoodsRecyclerAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            FoodsListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) =
        holder.setData(dataList[position])

    override fun getItemCount(): Int = dataList.size

    inner class ListViewHolder(private val binding: FoodsListItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(data: FoodEntity) {
            data.apply {

                Glide.with(context).load(image)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(binding.imageFood)

                binding.tvFoodName.text = name

                itemView.setOnClickListener {
                    onBindData.showDetailFood(id)
                }
            }
        }
    }

    fun dataUpdate(newList: ArrayList<FoodEntity>) {
        val diffCallback = RecyclerDiffUtils(oldList = dataList, newList = newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        dataList.clear()
        dataList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }
}