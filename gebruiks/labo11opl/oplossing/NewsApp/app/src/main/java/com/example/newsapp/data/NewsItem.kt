package com.example.newsapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_items")
data class NewsItem (
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "category")
    val category: String,
    @ColumnInfo(name = "subcategory")
    val subCategory: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "content")
    val content: String
)