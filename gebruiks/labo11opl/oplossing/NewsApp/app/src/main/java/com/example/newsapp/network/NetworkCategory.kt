package com.example.newsapp.network

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCategory(
    val id: String,
    val title: String,
    @SerialName(value = "subcategorieen")
    val subcategories: List<String>
)