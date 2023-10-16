package com.example.newsapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCategory(category: Category)

    @Query("SELECT * from categories")
    fun getAllCategories(): Flow<List<Category>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNewsItem(newsItem: NewsItem)

    @Query("SELECT * from news_items")
    fun getAllNewsItems(): Flow<List<NewsItem>>

    @Query("SELECT * from news_items where subcategory = :subCategory")
    fun getAllNewsItems(subCategory: String): Flow<List<NewsItem>>
}