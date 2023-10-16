package com.example.newsapp.data

import android.content.Context
import com.example.newsapp.network.NewsApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val newsRepository: NewsRepository

}

class DefaultAppContainer(private val context: Context) : AppContainer {
    private val BASE_URL = "https://623b4a952e056d1037f0689b.mockapi.io/"

    @OptIn(ExperimentalSerializationApi::class)
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: NewsApiService by lazy {
        retrofit.create(NewsApiService::class.java)
    }

    override val newsRepository: NewsRepository by lazy {
        NewsRepository(
            NewsDatabase.getDatabase(context).newsDao(),
            retrofitService
        )
    }
}