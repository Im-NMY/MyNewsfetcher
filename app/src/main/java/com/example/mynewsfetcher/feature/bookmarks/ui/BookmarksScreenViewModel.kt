package com.example.mynewsfetcher.feature.bookmarks.ui

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.viewModelScope
import com.example.mynewsfetcher.base.BaseViewModel
import com.example.mynewsfetcher.base.Event
import com.example.mynewsfetcher.feature.bookmarks.domain.BookmarksInteractor
import kotlinx.coroutines.launch

class BookmarksScreenViewModel(private val interactor: BookmarksInteractor) :
    BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadBookmarks)
    }

    override fun initialViewState(): ViewState = ViewState(bookmarksArticle = emptyList())

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.LoadBookmarks -> {
                viewModelScope.launch {
                    interactor.read().fold(
                        onError = {},
                        onSuccess = {
                            processDataEvent(DataEvent.OnSuccessBookmarksLoaded(it))
                        }
                    )
                }
                return null
            }

            is DataEvent.OnSuccessBookmarksLoaded -> {
                Log.d("Room", "articleBookmark = ${event.bookmarksArticle}")
                return previousState.copy(bookmarksArticle = event.bookmarksArticle)
            }
            is UiEvent.OnBookmarkedClicked -> {
                viewModelScope.launch {
                    interactor.delete(previousState.bookmarksArticle[event.index])
                    processUiEvent(DataEvent.LoadBookmarks)
                }
                return null
            }
            else -> return null
        }
    }
}