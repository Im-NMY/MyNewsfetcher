package com.example.mynewsfetcher.feature.bookmarks.ui

import com.example.mynewsfetcher.base.Event
import com.example.mynewsfetcher.feature.mainscreen.domain.ArticleModel

data class ViewState(
    val bookmarksArticle: List<ArticleModel>
)

sealed class UiEvent() : Event {
    data class OnBookmarkedClicked(val index: Int) : UiEvent()
}

sealed class DataEvent : Event {

    object LoadBookmarks : DataEvent()
    data class OnSuccessBookmarksLoaded(val bookmarksArticle: List<ArticleModel>) : DataEvent()
    data class OnFailedBookmarksLoaded(val throwable: Throwable) : DataEvent()
}