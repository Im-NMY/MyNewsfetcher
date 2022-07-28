package com.example.mynewsfetcher.feature.mainscreen

import com.example.mynewsfetcher.base.Event
import com.example.mynewsfetcher.feature.domain.ArticleModel

data class ViewState(
    val articles: List<ArticleModel>
)
sealed class DataEvent: Event {
    object LoadArticles : DataEvent()
    data class OnLoadArticlesSucceed(val articles: List<ArticleModel>) : DataEvent()
}