package com.onestackdev.food.utils

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//--------------------------------------------------------------------------------------------------
//RecyclerView
fun setUpRecyclerLayoutManager(
    context: Context, rv: RecyclerView, isVertical: Boolean, isReverse: Boolean = false
) {
    rv.layoutManager = LinearLayoutManager(
        context, if (isVertical) RecyclerView.VERTICAL else RecyclerView.HORIZONTAL, isReverse
    )
}

fun setUpRecyclerGridLayout(
    context: Context, rv: RecyclerView, isVertical: Boolean, isReverse: Boolean = false
) {
    rv.layoutManager = GridLayoutManager(
        context, 2, if (isVertical) RecyclerView.VERTICAL else RecyclerView.HORIZONTAL, isReverse
    )
}
//--------------------------------------------------------------------------------------------------