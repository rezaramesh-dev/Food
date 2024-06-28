package com.onestackdev.food.db.extension

import com.onestackdev.food.db.model.FoodEntity

fun generateFoodsList(): List<FoodEntity> {

    val kababIngredient = mapOf(
        "گوشت" to " ۲ kg",
        "راسته گوساله" to "600 گرم",
        "پیاز" to "200 گرم",
        "کره" to "25 گرم"
    )

    val kabab = FoodEntity(
        id = 0,
        categoryId = 2,
        name = "کباب",
        image = "https://www.digikala.com/mag/wp-content/uploads/2018/07/stuffed-fish.jpg",
        recipe = "مرحله اول: طریقه درست کردن کباب کوبیده خانگی حرفه\u200Cای احتیاج به کمی دقت و حوصله دارد. در شروع کار ابتدا گوشت چرخ\u200Cکرده را در یک ظرف بزرگ و گود بریزید و کمی نمک به آن اضافه کنید. گوشت و نمک را خوب ورز بدهید. در همین مرحله برای مزه\u200Cدار کردن گوشت گوساله و گوسفند برای کباب می\u200Cتوانید فلفل سیاه و زعفران را هم اضافه کنید تا بوی زهم گوشت از بین برود. گوشت را در یخچال بگذارید کمی به گوشت استراحت بدهید تا به اصطلاح بیات شود.",
        ingredients = kababIngredient
    )

    val pizzaIngredient = mapOf(
        "آرد" to " 3 پیمانه",
        "تخم مرغ" to "1 عدد",
        "خمیر مایه" to "1 قاشق غذا خوری",
        "شکر" to "4 قاشق غذا خوری"
    )

    val pizza = FoodEntity(
        id = 0,
        categoryId = 3,
        name = "پیتزا",
        image = "https://www.digikala.com/mag/wp-content/uploads/2018/07/shrimp.jpg",
        recipe = "برای تهیه پیتزا مخلوط ابتدا باید خمیر آن را تهیه کنید بدین منظور در ظرف مناسبی یک لیوان شیر ولرم را به همراه خمیر مایه و یک قاشق غذاخوری شکر بریزید و شروع به هم زدن بکنید. ",
        ingredients = pizzaIngredient
    )

    return listOf(kabab, pizza)
}

