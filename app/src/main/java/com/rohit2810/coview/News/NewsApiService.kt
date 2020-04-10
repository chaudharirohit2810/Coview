package com.rohit2810.coview.News

import android.database.Observable
import com.rohit2810.coview.News.Model.NewsWeatherResponse
import kotlinx.coroutines.Deferred
import okhttp3.Call
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface NewsApiService {

    @GET("top-headlines")
    suspend fun getNews(): NewsWeatherResponse


    companion object{
        operator fun invoke(): NewsApiService {

            val requestInterceptor = Interceptor {chain ->  
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("apiKey", "8702ccf0af9847b3854170a2b032f72f")
                    .build()

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            val path = "http://newsapi.org/v2/"
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NewsApiService::class.java)
        }
    }
}