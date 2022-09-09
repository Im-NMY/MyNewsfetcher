package com.example.mynewsfetcher.feature.domain

import com.example.mynewsfetcher.base.attempt
import com.example.mynewsfetcher.feature.data.ArticlesRepository

class ArticlesInteractor(private val repository: ArticlesRepository) {

    suspend fun getArticles() = attempt { repository.getArticles() }
}