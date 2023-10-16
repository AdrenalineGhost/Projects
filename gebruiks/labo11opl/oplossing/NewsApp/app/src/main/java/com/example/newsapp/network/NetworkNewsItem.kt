package com.example.newsapp.network

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkNewsItem(
    val id: String,
    val category: String,
    @SerialName("subcategory")
    val subCategory: String,
    val title: String,
    val content: String
)