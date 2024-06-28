package com.onestackdev.food.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.onestackdev.food.databinding.IngredientsItemListBinding

class IngredientsRecyclerAdapter(
    private val dataList: Map<String, String>, private val context: Context
) : RecyclerView.Adapter<IngredientsRecyclerAdapter.ListViewHolder>() {

    private val entries = dataList.entries.toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            IngredientsItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val entry = entries[position]
        holder.setData(entry.key, entry.value)
    }

    override fun getItemCount(): Int = dataList.size

    inner class ListViewHolder(private val binding: IngredientsItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(key: String, value: String) {
            binding.tvKey.text = key
            binding.tvValue.text = value
        }
    }
}