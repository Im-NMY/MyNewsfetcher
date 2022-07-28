package com.example.mynewsfetcher.feature.data

import com.example.mynewsfetcher.feature.data.module.ArticleRemoteModel
import com.example.mynewsfetcher.feature.domain.ArticleModel

fun ArticleRemoteModel.toDomain() = ArticleModel(
        author = author ?:"",
        tittle = tittle ?:"" ,
        description = description ?:"",
        url = url
)