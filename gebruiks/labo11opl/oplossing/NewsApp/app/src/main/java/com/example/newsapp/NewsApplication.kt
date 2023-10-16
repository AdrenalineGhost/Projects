package com.example.newsapp

import android.app.Application
import com.example.newsapp.data.AppContainer
import com.example.newsapp.data.DefaultAppContainer

class NewsApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        this.container = DefaultAppContainer(this)
    }
}