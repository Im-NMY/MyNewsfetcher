package com.example.mynewsfetcher.feature.mainscreen.data

import com.example.mynewsfetcher.feature.mainscreen.data.module.ArticleRemoteModel
import com.example.mynewsfetcher.feature.mainscreen.domain.ArticleModel

fun ArticleRemoteModel.toDomain() = ArticleModel(
    author = author ?: "",
    title = title ?: "",
    description = description ?: "",
    url = url,
    urlToImage = urlToImage ?: "",
    publishedAt = publishedAt ?: "",
    content = content ?: "",
)