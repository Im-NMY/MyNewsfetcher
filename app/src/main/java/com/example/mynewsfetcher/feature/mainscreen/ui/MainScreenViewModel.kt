package com.example.mynewsfetcher.feature.mainscreen.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.mynewsfetcher.base.BaseViewModel
import com.example.mynewsfetcher.base.Event
import com.example.mynewsfetcher.feature.bookmarks.domain.BookmarksInteractor
import com.example.mynewsfetcher.feature.mainscreen.domain.ArticlesInteractor
import kotlinx.coroutines.launch

class MainScreenViewModel(
    private val interactor: ArticlesInteractor,
    private val bookmarksInteractor: BookmarksInteractor
) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadArticles)
    }

    override fun initialViewState() = ViewState(
        articlesList = emptyList(),
        articlesShown = emptyList(),
        editText = "",
        isSearchEnable = false
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.LoadArticles -> {
                viewModelScope.launch {
                    interactor.getArticles().fold(
                        onError = {
                            Log.e("Error", it.localizedMessage)
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.OnLoadArticlesSucceed(it))
                        }
                    )
                }
                return null
            }
            is DataEvent.OnLoadArticlesSucceed -> {
                return previousState.copy(
                    articlesList = event.articles,
                    articlesShown = event.articles
                )
            }
            is UiEvent.OnArticleClicked -> {
                previousState.articlesList[event.index].bookmarkFlag = true
                viewModelScope.launch {
                    bookmarksInteractor.create(previousState.articlesShown[event.index])
                }
                return null
            }
            is UiEvent.OnSearchButtonClicked -> {
                return previousState.copy(
                    articlesShown = if (previousState.isSearchEnable && previousState.editText == "") previousState.articlesList else previousState.articlesShown,
                    isSearchEnable = !previousState.isSearchEnable
                )
            }
            is UiEvent.OnSearchEdit -> {
                previousState.editText = event.txt
                return previousState.copy(articlesShown = previousState.articlesList.filter {
                    it.title!!.contains(event.txt)
                }, isSearchEnable = previousState.isSearchEnable)
            }
            else -> return null
        }
    }
}