package com.aman.paging3compose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.aman.paging3compose.model.RecipeX
import com.aman.paging3compose.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow

class RecipeViewModel:ViewModel() {

    private val repository = RecipeRepository()

    val recipes: Flow<PagingData<RecipeX>> = repository.getRecipes().cachedIn(viewModelScope)
}