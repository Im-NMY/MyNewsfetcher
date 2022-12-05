package com.example.mynewsfetcher.feature.mainscreen.data

import com.example.mynewsfetcher.feature.mainscreen.domain.ArticleModel

interface ArticlesRepository {
    suspend fun getArticles(): List<ArticleModel>
}