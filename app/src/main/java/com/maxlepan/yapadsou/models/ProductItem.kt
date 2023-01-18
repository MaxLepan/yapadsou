package com.maxlepan.yapadsou.models

data class ProductItem(
    val image: String = "",
    val title: String = "",
    val subTitle: String = "",
    val userId: String = "",
    var itemId: String = "",
    var stars: Int = 0,
    var nbTest: Int = 0,
    val description: String = "",
    val link: String = ""
)
