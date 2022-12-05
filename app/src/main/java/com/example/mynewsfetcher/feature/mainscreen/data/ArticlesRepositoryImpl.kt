package com.example.mynewsfetcher.feature.mainscreen.data

import com.example.mynewsfetcher.feature.mainscreen.data.ArticlesRepository
import com.example.mynewsfetcher.feature.mainscreen.domain.ArticleModel

class ArticlesRepositoryImpl(private val source: ArticlesRemoteSource) : ArticlesRepository {
    override suspend fun getArticles(): List<ArticleModel> {
        return source.getArticles().articleList.map {
            it.toDomain()
        }
    }
}