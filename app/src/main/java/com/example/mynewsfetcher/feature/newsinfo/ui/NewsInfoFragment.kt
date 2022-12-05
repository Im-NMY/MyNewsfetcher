package com.example.mynewsfetcher.feature.newsinfo.ui

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.mynewsfetcher.di.BUNDLE_KEY_FOR_ARTICLE_MODEL
import com.example.mynewsfetcher.R
import com.example.mynewsfetcher.feature.mainscreen.domain.ArticleModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.concurrent.Executors

class NewsInfoFragment : Fragment(R.layout.fragment_news_info) {

    private val viewModel: InfoScreenViewModel by viewModel()
    private val articleImage: ImageView by lazy { requireActivity().findViewById(R.id.ivArticle) }
    private val articleTitle: TextView by lazy { requireActivity().findViewById(R.id.tvArticleTitle) }
    private val articleDescription: TextView by lazy { requireActivity().findViewById(R.id.tvArticleDescription) }
    private val articleUrl: TextView by lazy { requireActivity().findViewById(R.id.tvArticleUrl) }
    private val backFromArticleScreenButton: ImageView by lazy { requireActivity().findViewById(R.id.btnBackFromArticleScreen) }

    companion object {
        @JvmStatic
        fun newInstance(arg: Bundle?): NewsInfoFragment {
            val infoFragment = NewsInfoFragment()
            infoFragment.arguments = arg
            return infoFragment
        }
    }

    private fun getImageOfArticleFromUrl(urlToImage: String) {
        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())
        var image: Bitmap?
        executor.execute {
            try {
                val `in` = java.net.URL(urlToImage).openStream()
                image = BitmapFactory.decodeStream(`in`)
                handler.post {
                    articleImage.setImageBitmap(image)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)
        val currentArticle: ArticleModel =
            this.arguments?.get(BUNDLE_KEY_FOR_ARTICLE_MODEL) as ArticleModel
        viewModel.processUiEvent(DataEvent.ShowArticle(currentArticle))

        backFromArticleScreenButton.setOnClickListener {
            parentFragmentManager.beginTransaction().remove(this).commit()
        }
        articleUrl.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(currentArticle.url)
            startActivity(i)
        }

    }

    private fun render(viewState: ViewState) {
        articleTitle.text = viewState.articleTitle
        articleDescription.text = viewState.articleDescription
        articleUrl.text = viewState.articleUrl
        viewState.articleUrlToImage?.let { getImageOfArticleFromUrl(it) }
    }
}