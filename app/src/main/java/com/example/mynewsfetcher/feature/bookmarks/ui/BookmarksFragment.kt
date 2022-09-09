package com.example.mynewsfetcher.feature.bookmarks.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.mynewsfetcher.BUNDLE_KEY_FOR_ARTICLE_MODEL
import com.example.mynewsfetcher.R
import com.example.mynewsfetcher.feature.domain.ArticleModel
import com.example.mynewsfetcher.feature.newsinfo.ui.NewsInfoFragment

import org.koin.androidx.viewmodel.ext.android.viewModel

class BookmarksFragment : Fragment(R.layout.fragment_bookmarks) {

    private val viewModel: BookmarksScreenViewModel by viewModel()
    private val recyclerView: RecyclerView by lazy { requireActivity().findViewById(R.id.rvBookmarkedArticles) }
    private val adapter: BookmarksAdapter by lazy {
        BookmarksAdapter(
            { currentArticle -> openArticle(currentArticle) },
            { index -> viewModel.processUiEvent(UiEvent.OnBookmarkedClicked(index)) }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)
        recyclerView.adapter = adapter

    }

    private fun render(viewState: ViewState) {
        adapter.setData(viewState.bookmarksArticle)

    }

    private fun openArticle(currentArticle: ArticleModel) {
        val bundle = Bundle()
        bundle.putParcelable(BUNDLE_KEY_FOR_ARTICLE_MODEL, currentArticle)
        parentFragmentManager.beginTransaction().add(
            R.id.container, NewsInfoFragment.newInstance(bundle)
        ).commit()
    }
}