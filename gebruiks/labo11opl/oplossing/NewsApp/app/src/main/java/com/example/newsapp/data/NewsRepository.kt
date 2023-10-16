package com.example.newsapp.data

import com.example.newsapp.network.NewsApiService
import kotlinx.coroutines.flow.Flow

class NewsRepository(
    private val newsDao: NewsDao,
    private val service: NewsApiService
) {
    suspend fun fetchCategories() {
        service.getCategories().map {
            Category(it.id, it.title, it.subcategories)
        }.forEach {
            insertCategory(it)
        }
    }

    suspend fun insertCategory(category: Category) = newsDao.insertCategory(category)

    fun getAllCategoriesStream(): Flow<List<Category>> = newsDao.getAllCategories()

    suspend fun fetchNewsItems() {
        service.getNewsItems().map {
            NewsItem(it.id, it.category, it.subCategory, it.title, it.content)
        }.forEach {
            insertNewsItem(it)
        }
    }

    suspend fun insertNewsItem(item: NewsItem) = newsDao.insertNewsItem(item)

    fun getAllNewsItemsStream(): Flow<List<NewsItem>> = newsDao.getAllNewsItems()

    fun getallNewsItemsStream(subCategory: String): Flow<List<NewsItem>> =
        newsDao.getAllNewsItems(subCategory)

}