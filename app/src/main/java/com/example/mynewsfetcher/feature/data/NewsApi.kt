package com.example.mynewsfetcher.feature.data

import com.example.mynewsfetcher.API_KEY
import com.example.mynewsfetcher.feature.data.module.ArticleRemoteModel
import com.example.mynewsfetcher.feature.data.module.ArticlesRemoteModel
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/top-headlines")
    suspend fun getArticles(
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("country") country: String = "ru"
    ): ArticlesRemoteModel
}