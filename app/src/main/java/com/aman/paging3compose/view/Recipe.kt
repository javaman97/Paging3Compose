package com.aman.paging3compose.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import com.aman.paging3compose.viewmodel.RecipeViewModel
import com.aman.paging3compose.model.RecipeX

@Composable
fun RecipeScreen(recipeViewModel: RecipeViewModel) {
    val recipes = recipeViewModel.recipes.collectAsLazyPagingItems()

    LazyColumn {
        items(recipes.itemCount) { index ->
            recipes[index]?.let { recipe ->
                RecipeItem(recipe)
            }
        }
    }
}

@Composable
fun RecipeItem(recipe: RecipeX) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = recipe.name, style = typography.bodyLarge)
            Text(text = recipe.cuisine, style = typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            AsyncImage(
                model = recipe.image,
                contentDescription = recipe.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}


