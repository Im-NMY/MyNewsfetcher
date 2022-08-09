package com.example.mynewsfetcher.feature.bookmarks.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mynewsfetcher.R
import com.example.mynewsfetcher.feature.domain.ArticleModel

class BookmarksAdapter : RecyclerView.Adapter<BookmarksAdapter.ViewHolder>() {

    private var articlesData: List<ArticleModel> = emptyList()

    /**
     * Укажите ссылку на тип представлений, которые вы используете.
     * (пользовательский ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textAuthor: TextView = view.findViewById(R.id.tvAuthor)
        val textTitle: TextView = view.findViewById(R.id.tvTitle)
        val textDescription: TextView = view.findViewById(R.id.tvDescription)
        val textUrl: TextView = view.findViewById(R.id.tvUrl)
        val textUrlToImage: TextView = view.findViewById(R.id.tvUrlToImage)
        val textPublishedAt: TextView = view.findViewById(R.id.tvPublishedAt)
        val textContent: TextView = view.findViewById(R.id.tvContent)
    }

    // Создание новых представлений (вызывается менеджером компоновки)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Создайте новое представление, определяющее пользовательский интерфейс элемента списка
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_article, viewGroup, false)

        return ViewHolder(view)
    }

    // Заменить содержимое представления (вызывается менеджером компоновки)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Получите элемент из вашего набора данных в этой позиции и замените
        // содержимое представления с этим элементом
        viewHolder.textAuthor.text = articlesData[position].author
        viewHolder.textTitle.text = articlesData[position].title
        viewHolder.textDescription.text = articlesData[position].description
        viewHolder.textUrl.text = articlesData[position].url
        viewHolder.textUrlToImage.text = articlesData[position].urlToImage
        viewHolder.textPublishedAt.text = articlesData[position].publishedAt
        viewHolder.textContent.text = articlesData[position].content
    }

    // Вернуть размер вашего набора данных (вызывается менеджером компоновки)
    override fun getItemCount() = articlesData.size

    fun setData(bookmarksArticle: List<ArticleModel>){
        articlesData = bookmarksArticle
        notifyDataSetChanged()
    }

}