package com.aman.paging3compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.aman.paging3compose.ui.theme.Paging3ComposeTheme
import com.aman.paging3compose.view.RecipeScreen
import com.aman.paging3compose.viewmodel.RecipeViewModel

class MainActivity : ComponentActivity() {
    private val recipeViewModel: RecipeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Paging3ComposeTheme {
                   RecipeScreen(recipeViewModel = RecipeViewModel())
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Paging3ComposeTheme {
        val viewModel = RecipeViewModel()
        RecipeScreen(viewModel)
    }
}