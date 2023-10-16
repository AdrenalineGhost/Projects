package com.example.newsapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.newsapp.NewsTopAppBar
import com.example.newsapp.ui.NewsViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SubCategoryScreen(
    viewModel: NewsViewModel,
    onSubCategorySelected: () -> Unit,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()

    val selectedCategoryIndex: Int =
        uiState.categories.indexOf(uiState.selectedCategory)

    Scaffold(
        topBar = {
            NewsTopAppBar(
                title = uiState.selectedCategory?.title ?: "",
                canNavigateBack = true,
                navigateUp = navigateUp
            )
        }
    ) {
        SubCategoryListScreen(
            subCategories = uiState.categories[selectedCategoryIndex].subcategories,
            subCategorySelectedHandler = {
                viewModel.selectSubCategory(it)
                onSubCategorySelected()
            },
            modifier
        )
    }
}

@Composable
fun SubCategoryListScreen(
    subCategories: List<String>,
    subCategorySelectedHandler: (subCategory: String) -> Unit,

    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(subCategories) {
            SubCategoryCard(
                subCategory = it,
                subCategorySelectedHandler = subCategorySelectedHandler,
                modifier = modifier
            )
        }
    }
}

@Composable
fun SubCategoryCard(
    subCategory: String,
    subCategorySelectedHandler: (subCategory: String) -> Unit,
    modifier: Modifier
) {
    Card(
        modifier = modifier.padding(8.dp), elevation = 4.dp
    ) {
        Row {
            Box(
                modifier = modifier
                    .fillMaxHeight()
                    .align(Alignment.CenterVertically)
                    .padding(2.dp)
                    .clickable {
                        subCategorySelectedHandler(subCategory)
                    }
            ) {
                Text(
                    text = subCategory,
                    textAlign = TextAlign.Left,
                    style = MaterialTheme.typography.h4,
                    modifier = modifier.fillMaxWidth()
                )
            }
        }
    }
}