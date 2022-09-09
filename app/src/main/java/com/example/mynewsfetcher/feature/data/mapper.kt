package com.example.mynewsfetcher.feature.data

import com.example.mynewsfetcher.feature.data.module.ArticleRemoteModel
import com.example.mynewsfetcher.feature.domain.ArticleModel

fun ArticleRemoteModel.toDomain() = ArticleModel(
    author = author ?: "",
    title = title ?: "",
    description = description ?: "",
    url = url,
    urlToImage = urlToImage ?: "",
    publishedAt = publishedAt ?: "",
    content = content ?: "",
)