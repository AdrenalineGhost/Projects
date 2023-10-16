package com.example.newsapp.ui

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.*
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.newsapp.NewsApplication
import com.example.newsapp.data.Category
import com.example.newsapp.data.NewsItem
import com.example.newsapp.data.NewsRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

enum class DataLoadState() {
    Success, Error, Loading
}

data class GlobalState(
    val selectedCategory: Category? = null,
    val selectedSubCategory: String = "",
    val articles: List<NewsItem> = listOf(),
    val articlesToShow: List<NewsItem> = listOf(),
    val dataLoadState: DataLoadState = DataLoadState.Loading,
    val categories: List<Category> = listOf(),
    val selectedArticle: NewsItem? = null,
    val searchText: String = ""
)

class NewsViewModel(
    private val newsRepository: NewsRepository, private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(GlobalState())
    val uiState: StateFlow<GlobalState> = _uiState.asStateFlow()

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val savedStateHandle = createSavedStateHandle()
                val categoryRepository =
                    (this[APPLICATION_KEY] as NewsApplication).container.newsRepository
                NewsViewModel(
                    newsRepository = categoryRepository,
                    savedStateHandle = savedStateHandle
                )
            }
        }
    }

    init {
        getData()
    }


    fun getData() {
        viewModelScope.launch {
            try {
                newsRepository.fetchCategories()
                newsRepository.fetchNewsItems()
            } catch (e: IOException) {
                _uiState.update { currentState ->
                    currentState.copy(
                        dataLoadState = DataLoadState.Error
                    )
                }
            } catch (e: HttpException) {
                _uiState.update { currentState ->
                    currentState.copy(
                        dataLoadState = DataLoadState.Error
                    )
                }
            }

            newsRepository.getAllCategoriesStream().collect { _categories ->
                _uiState.update { currentState ->
                    currentState.copy(
                        dataLoadState = DataLoadState.Success,
                        categories = _categories
                    )
                }
            }
        }
    }

    fun selectCategory(category: Category): Unit {
        _uiState.update { currentState ->
            currentState.copy(
                selectedCategory = category
            )
        }
    }

    fun selectSubCategory(subCategory: String) {
        _uiState.update { currentState ->
            currentState.copy(
                selectedSubCategory = subCategory
            )
        }

        viewModelScope.launch {
            updateArticles()
        }
    }

    private suspend fun updateArticles() {
        newsRepository.getallNewsItemsStream(uiState.value.selectedSubCategory)
            .collect { newsItems ->
                _uiState.update { currentState ->
                    currentState.copy(
                        articles = newsItems
                    )
                }
                filterArticles()
            }
    }

    fun selectArticle(article: NewsItem) {
        _uiState.update { currentState ->
            currentState.copy(
                selectedArticle = article
            )
        }
    }

    fun updateSearchText(text: String) {
        _uiState.update { currentState ->
            currentState.copy(
                searchText = text
            )
        }
    }

    fun filterArticles(){
        _uiState.update { currentState ->
            currentState.copy(
                articlesToShow = currentState.articles.filter { newsItem ->
                    newsItem.title.contains(currentState.searchText)
                }
            )
        }
    }
}