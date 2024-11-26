package com.aman.paging3compose.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.aman.paging3compose.api.RetrofitInstance
import com.aman.paging3compose.model.RecipeX
import com.aman.paging3compose.paging.RecipePagingSource
import com.aman.paging3compose.utils.Const
import kotlinx.coroutines.flow.Flow

class RecipeRepository {

    private val api = RetrofitInstance.api

    fun getRecipes() : Flow<PagingData<RecipeX>> = Pager(
        config = PagingConfig(
            pageSize = Const.PAGE_SIZE,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            RecipePagingSource(api)
        }
    ).flow
}