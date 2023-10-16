package com.example.newsapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.newsapp.ui.NewsViewModel
import com.example.newsapp.ui.screens.ArticlesScreen
import com.example.newsapp.ui.screens.CategoryScreen
import com.example.newsapp.ui.screens.DetailScreen
import com.example.newsapp.ui.screens.SubCategoryScreen

@Composable
fun NewsNavHost(
    navController: NavHostController,
    newsViewModel: NewsViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = NavigationDestination.Categories.name,
        modifier = modifier
    ) {
        composable(route = NavigationDestination.Categories.name) {
            CategoryScreen(
                viewModel = newsViewModel,
                onCategorySelected = {
                    navController.navigate(NavigationDestination.SubCategories.name)
                }
            )
        }
        composable(route = NavigationDestination.SubCategories.name) {
            SubCategoryScreen(
                viewModel = newsViewModel,
                onSubCategorySelected = {
                    navController.navigate(NavigationDestination.Articles.name)
                },
                navigateUp = {
                    navController.navigateUp()
                }
            )
        }
        composable(route = NavigationDestination.Articles.name) {
            ArticlesScreen(
                viewModel = newsViewModel,
                onArticleSelected = {
                    navController.navigate(NavigationDestination.Details.name)
                },
                navigateUp = {
                    navController.navigateUp()
                }
            )
        }
        composable(route = NavigationDestination.Details.name) {
            DetailScreen(
                viewModel = newsViewModel,
                navigateUp = {
                    navController.navigateUp()
                }
            )
        }
    }
}