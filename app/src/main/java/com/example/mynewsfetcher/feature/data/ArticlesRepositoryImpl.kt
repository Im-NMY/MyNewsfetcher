package com.example.mynewsfetcher.feature.data

import com.example.mynewsfetcher.feature.data.ArticlesRepository
import com.example.mynewsfetcher.feature.domain.ArticleModel

class ArticlesRepositoryImpl(private val source: ArticlesRemoteSource) : ArticlesRepository {
    override suspend fun getArticles(): List<ArticleModel> {
        return source.getArticles().articleList.map {
            it.toDomain()
        }
    }
}