package com.example.mynewsfetcher.feature.mainscreen.data


import com.example.mynewsfetcher.feature.mainscreen.data.module.ArticlesRemoteModel

class ArticlesRemoteSource(private val api: NewsApi) {

    suspend fun getArticles(): ArticlesRemoteModel {
        return api.getArticles()
    }
}