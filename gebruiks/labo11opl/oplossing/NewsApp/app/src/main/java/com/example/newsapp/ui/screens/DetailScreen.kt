package com.example.newsapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.newsapp.NewsTopAppBar
import com.example.newsapp.ui.NewsViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen(
    viewModel: NewsViewModel,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    val scroll = rememberScrollState(0)

    Scaffold(
        topBar = {
            NewsTopAppBar(
                title = (uiState.selectedCategory?.title ?: "")
                        + " > " + uiState.selectedSubCategory
                        + " > " + (uiState.selectedArticle?.title ?: ""),
                canNavigateBack = true,
                navigateUp = navigateUp
            )
        }
    ) {
        Text(
            text = uiState.selectedArticle?.content ?: "",
            modifier = modifier
                .padding(8.dp)
                .verticalScroll(scroll),
            textAlign = TextAlign.Justify
        )
    }
}