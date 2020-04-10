package com.rohit2810.coview.News

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rohit2810.coview.News.Model.NewsWeatherResponse

class NewsRepository {
    val newsApiService = NewsApiService()


    suspend fun getNews() = newsApiService.getNews()

}