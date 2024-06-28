package com.onestackdev.food.db.extension

import com.onestackdev.food.db.model.CategoryEntity

fun generateCategoryList(): List<CategoryEntity> {

    val sonati = CategoryEntity(
        id = 0,
        categoryName = "sonati",
        name = "سنتی",
        image = "https://www.digikala.com/mag/wp-content/uploads/2018/07/Tahchin.jpg"
    )

    val irani = CategoryEntity(
        id = 0,
        categoryName = "irani",
        name = "ایرانی",
        image = "https://www.digikala.com/mag/wp-content/uploads/2018/07/tahchin2.jpg"
    )

    val fastfood = CategoryEntity(
        id = 0,
        categoryName = "fastfood",
        name = "فست فود",
        image = "https://www.digikala.com/mag/wp-content/uploads/2018/07/kofte-tabriz.jpg"
    )

    val student = CategoryEntity(
        id = 0,
        categoryName = "student",
        name = "دانشحویی",
        image = "https://www.digikala.com/mag/wp-content/uploads/2018/07/pan-kebab.jpg"
    )

    return listOf(sonati, irani, fastfood, student)
}