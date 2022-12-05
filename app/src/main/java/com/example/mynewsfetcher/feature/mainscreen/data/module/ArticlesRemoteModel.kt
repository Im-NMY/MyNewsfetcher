package com.example.mynewsfetcher.feature.mainscreen.data.module

import com.google.gson.annotations.SerializedName

data class ArticlesRemoteModel (
    @SerializedName("articles")
    val articleList: List<ArticleRemoteModel>
)