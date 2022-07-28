package com.example.mynewsfetcher.feature.data

import com.example.mynewsfetcher.feature.domain.ArticleModel

interface ArticlesRepository {
    suspend fun getArticles(): List<ArticleModel>
}