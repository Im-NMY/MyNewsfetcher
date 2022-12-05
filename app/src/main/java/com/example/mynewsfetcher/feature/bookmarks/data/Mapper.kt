package com.example.mynewsfetcher.feature.bookmarks.data

import com.example.mynewsfetcher.feature.bookmarks.data.local.model.BookmarkEntity
import com.example.mynewsfetcher.feature.mainscreen.domain.ArticleModel

fun BookmarkEntity.toDomain() = ArticleModel(
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content
)

fun ArticleModel.toEntity() = BookmarkEntity(
    title = title ?: "",
    author = author ?: "",
    description = description ?: "",
    url = url ?: "",
    urlToImage = urlToImage ?: "",
    publishedAt = publishedAt ?: "",
    content = content ?: ""
)