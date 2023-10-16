package com.example.newsapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.newsapp.NewsTopAppBar
import com.example.newsapp.R
import com.example.newsapp.data.Category
import com.example.newsapp.ui.DataLoadState
import com.example.newsapp.ui.NewsViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CategoryScreen(
    viewModel: NewsViewModel,
    onCategorySelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            NewsTopAppBar(
                title = stringResource(R.string.categories),
                canNavigateBack = false
            )
        }
    ) {
        when (uiState.dataLoadState) {
            DataLoadState.Loading -> LoadingScreen(modifier)
            DataLoadState.Success -> CategoryListScreen(
                uiState.categories,
                { category: Category ->
                    viewModel.selectCategory(category = category)
                    onCategorySelected()
                },
                modifier
            )
            DataLoadState.Error -> ErrorScreen({ viewModel.getData() }, modifier)
        }
    }
}

@Composable
fun CategoryListScreen(
    categories: List<Category>,
    categorySelectedHandler: (category: Category) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(categories) {
            CategoryCard(
                category = it,
                categorySelectedHandler = categorySelectedHandler,
                modifier = modifier
            )
        }
    }
}

@Composable
fun CategoryCard(
    category: Category,
    categorySelectedHandler: (category: Category) -> Unit,
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
                        categorySelectedHandler(category)
                    }
            ) {
                Text(
                    text = category.title,
                    textAlign = TextAlign.Left,
                    style = MaterialTheme.typography.h4,
                    modifier = modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(R.drawable.loading_img),
            contentDescription = stringResource(R.string.loading_img)
        )
    }
}

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(R.string.loading_failed))
        Button(onClick = retryAction) {
            Text(stringResource(R.string.retry))
        }
    }
}