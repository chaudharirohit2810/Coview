package com.rohit2810.coview.News.Model


import com.google.gson.annotations.SerializedName

data class NewsWeatherResponse(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)