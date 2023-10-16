package com.example.newsapp.network

import com.example.newsapp.data.Category
import retrofit2.http.GET

interface NewsApiService {
    @GET("onderwerpen")
    suspend fun getCategories(): List<NetworkCategory>

    @GET("items")
    suspend fun getNewsItems(): List<NetworkNewsItem>
}