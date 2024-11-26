package com.aman.paging3compose.api

import com.aman.paging3compose.model.Recipe
import com.aman.paging3compose.model.RecipeX
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiHelper {

    @GET("recipes")
    suspend fun getRecipe(
        @Query("limit") limit:Int,
        @Query("skip") skip:Int
    ):Recipe
}