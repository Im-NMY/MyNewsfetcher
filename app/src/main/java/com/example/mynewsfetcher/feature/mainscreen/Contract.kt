package com.example.mynewsfetcher.feature.mainscreen

import com.example.mynewsfetcher.base.Event
import com.example.mynewsfetcher.feature.domain.ArticleModel

data class ViewState(
    val isSearchEnable: Boolean,
    var editText: String?,
    val articlesShown: List<ArticleModel>,
    val articlesList: List<ArticleModel>
)

sealed class UiEvent : Event {
    data class OnArticleClicked(val index: Int) : UiEvent()
    data class OnSearchEdit(val txt: String) : UiEvent()
    object OnSearchButtonClicked : UiEvent()
}

sealed class DataEvent : Event {
    object LoadArticles : DataEvent()
    data class OnLoadArticlesSucceed(val articles: List<ArticleModel>) : DataEvent()

}