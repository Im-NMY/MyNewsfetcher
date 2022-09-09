package com.example.mynewsfetcher.feature.newsinfo.ui

import com.example.mynewsfetcher.base.Event
import com.example.mynewsfetcher.feature.domain.ArticleModel

data class ViewState(
    val articleAuthor: String?,
    val articleTitle: String?,
    val articleDescription: String?,
    val articleContent: String?,
    val articleUrlToImage: String?,
    val articleUrl: String?,
    val articlePublishedAt: String?
)

sealed class UiEvent() : Event {
}

sealed class DataEvent() : Event {
    data class ShowArticle(val currentArticle: ArticleModel) : DataEvent()
}