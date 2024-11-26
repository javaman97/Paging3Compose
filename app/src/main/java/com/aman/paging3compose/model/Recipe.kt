package com.aman.paging3compose.model

data class Recipe(
    val limit: Int = 0,
    val recipes: List<RecipeX> = listOf(),
    val skip: Int = 0,
    val total: Int = 0
)