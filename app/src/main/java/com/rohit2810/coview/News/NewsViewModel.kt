package com.rohit2810.coview.News

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.rohit2810.coview.News.Model.NewsWeatherResponse
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    private val repository: NewsRepository


    init {
         repository = NewsRepository()
    }


    val allNews = liveData(Dispatchers.IO) {
        val news = repository.getNews()
        Log.d("ViewModel", news.toString())
        emit(news)
    }

}