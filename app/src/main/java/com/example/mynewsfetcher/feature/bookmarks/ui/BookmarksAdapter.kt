package com.example.mynewsfetcher.feature.bookmarks.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mynewsfetcher.R
import com.example.mynewsfetcher.feature.domain.ArticleModel

class BookmarksAdapter(
    private val onItemClicked: (ArticleModel) -> Unit,
    private val clickedRemoveBookmarks: (Int) -> Unit
) : RecyclerView.Adapter<BookmarksAdapter.ViewHolder>() {

    private var articlesData: List<ArticleModel> = emptyList()

    /**
     * Укажите ссылку на тип представлений, которые вы используете.
     * (пользовательский ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textTitle: TextView
        val textData: TextView
        val delBookmark: ImageView

        init {
            textTitle = view.findViewById(R.id.tvTitle)
            textData = view.findViewById(R.id.tvDate)
            delBookmark = view.findViewById<ImageView?>(R.id.ivBookmarkDel)
                .also { it.visibility = ImageView.VISIBLE }
        }
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
        viewHolder.delBookmark.setOnClickListener {
            clickedRemoveBookmarks.invoke(position)
        }
        viewHolder.itemView.setOnClickListener {
            onItemClicked.invoke(articlesData[position])
        }
        viewHolder.textTitle.text = articlesData[position].title
        viewHolder.textData.text = articlesData[position].publishedAt
    }

    // Вернуть размер вашего набора данных (вызывается менеджером компоновки)
    override fun getItemCount() = articlesData.size

    fun setData(bookmarksArticle: List<ArticleModel>) {
        articlesData = bookmarksArticle
        notifyDataSetChanged()
    }

}