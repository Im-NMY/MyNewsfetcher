package com.example.mynewsfetcher.feature.bookmarks.data.local

import com.example.mynewsfetcher.feature.mainscreen.domain.ArticleModel

interface BookmarksRepository {
    suspend fun create(model: ArticleModel)

    suspend fun read(): List<ArticleModel>

    suspend fun update(model: ArticleModel)

    suspend fun delete(model: ArticleModel)
}