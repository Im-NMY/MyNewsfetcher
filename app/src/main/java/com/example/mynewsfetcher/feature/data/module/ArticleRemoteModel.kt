package com.example.mynewsfetcher.feature.data.module

import com.google.gson.annotations.SerializedName

data class ArticleRemoteModel (
    @SerializedName("author")
    val author: String?,
    @SerializedName("tittle")
    val title: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String?,
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("content")
    val content: String?,
    )