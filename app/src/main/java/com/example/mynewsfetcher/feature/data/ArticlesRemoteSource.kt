package com.example.mynewsfetcher.feature.data

import com.example.mynewsfetcher.feature.data.module.ArticleRemoteModel
import com.example.mynewsfetcher.feature.data.module.ArticlesRemoteModel

class ArticlesRemoteSource(private val api: NewsApi) {

    suspend fun getArticles(): ArticlesRemoteModel {
        return api.getArticles()
    }
}