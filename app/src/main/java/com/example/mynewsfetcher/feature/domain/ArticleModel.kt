package com.example.mynewsfetcher.feature.domain

import com.google.gson.annotations.SerializedName

data class  ArticleModel (

    val author: String,
    val tittle: String,
    val description: String,
    val url: String,
//    val urlToImage: String,
//    val publishedAt: String,
//    val content: String,
        )