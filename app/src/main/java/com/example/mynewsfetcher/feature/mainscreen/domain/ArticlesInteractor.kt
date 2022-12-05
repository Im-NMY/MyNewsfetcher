package com.example.mynewsfetcher.feature.mainscreen.domain

import com.example.mynewsfetcher.base.attempt
import com.example.mynewsfetcher.feature.mainscreen.data.ArticlesRepository

class ArticlesInteractor(private val repository: ArticlesRepository) {

    suspend fun getArticles() = attempt { repository.getArticles() }
}