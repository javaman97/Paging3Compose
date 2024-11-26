package com.aman.paging3compose.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.aman.paging3compose.api.ApiHelper
import com.aman.paging3compose.model.RecipeX

class RecipePagingSource(private val api:ApiHelper):PagingSource<Int, RecipeX> (){

    override fun getRefreshKey(state: PagingState<Int, RecipeX>): Int? {
        Log.e("Paging Source"," GetRefreshKey ${state.anchorPosition}")
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(10) ?:
            state.closestPageToPosition(anchorPosition)?.nextKey?.minus(10)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RecipeX> {

        val position = params.key?:0
        val pageSize = params.loadSize

        return try {
            Log.e("Paging Source"," Position = $position and Page Size = $pageSize")
            val response = api.getRecipe(limit = pageSize, skip= position)
            LoadResult.Page(
                data = response.recipes,
                prevKey = if(position == 0) null else position - pageSize,
                nextKey = if(response.recipes.isEmpty()) null else position + pageSize
            )

        }catch (e:Exception){
            LoadResult.Error(e)
        }

    }
}