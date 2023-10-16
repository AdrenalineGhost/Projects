package com.example.newsapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.newsapp.NewsTopAppBar
import com.example.newsapp.data.Category
import com.example.newsapp.data.NewsItem
import com.example.newsapp.ui.NewsViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ArticlesScreen(
    viewModel: NewsViewModel,
    onArticleSelected: () -> Unit,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            NewsTopAppBar(
                title = (uiState.selectedCategory?.title ?: "")
                        + " > " + uiState.selectedSubCategory,
                canNavigateBack = true,
                navigateUp = navigateUp
            )
        }
    ) {
        Column {
            Row{
                Surface(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    elevation = 4.dp,
                    color = MaterialTheme.colors.surface
                )
                {
                    TextField(modifier = modifier
                        .fillMaxWidth(),
                        value = uiState.searchText,

                        onValueChange = {
                            viewModel.updateSearchText(it)
                            viewModel.filterArticles()
                        },
                        placeholder = {
                            Text(
                                text = "Search here",
                                style = MaterialTheme.typography.body1
                            )
                        },
                        singleLine = true,
                        leadingIcon = {
                            IconButton(
                                modifier = modifier,
                                onClick = {}
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Search,
                                    contentDescription = "",
                                )
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Search
                        ),
                        keyboardActions = KeyboardActions(
                            onSearch = {}
                        ),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent,
                            cursorColor = MaterialTheme.colors.onSurface
                        ),
                        textStyle = MaterialTheme.typography.body1
                    )
                }
            }
            ArticleListScreen(
                uiState.articlesToShow,
                { article: NewsItem ->
                    viewModel.selectArticle(article = article)
                    onArticleSelected()
                },
                modifier
            )
        }
    }
}

@Composable
fun ArticleListScreen(
    articles: List<NewsItem>,
    articleSelectedHandler: (article: NewsItem) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn {
        items(articles) {
            ArticleCard(
                article = it,
                articleSelectedHandler = articleSelectedHandler,
                modifier = modifier
            )
        }
    }
}

@Composable
fun ArticleCard(
    article: NewsItem,
    articleSelectedHandler: (article: NewsItem) -> Unit,
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
                        articleSelectedHandler(article)
                    }
            ) {
                Text(
                    text = article.title,
                    textAlign = TextAlign.Left,
                    style = MaterialTheme.typography.h4,
                    modifier = modifier.fillMaxWidth()
                )
            }
        }
    }
}