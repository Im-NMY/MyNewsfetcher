package com.example.mynewsfetcher.feature.di

import com.example.mynewsfetcher.feature.data.ArticlesRemoteSource
import com.example.mynewsfetcher.feature.data.ArticlesRepository
import com.example.mynewsfetcher.feature.data.ArticlesRepositoryImpl
import com.example.mynewsfetcher.feature.data.NewsApi
import com.example.mynewsfetcher.feature.domain.ArticlesInteractor
import com.example.mynewsfetcher.feature.mainscreen.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import kotlin.math.sin

val mainScreenModule = module {
    single<NewsApi> {
        get<Retrofit>().create(NewsApi::class.java)
    }

    single<ArticlesRemoteSource> {
        ArticlesRemoteSource(api = get())
    }

    single<ArticlesRepository> {
        ArticlesRepositoryImpl(source = get())
    }

    single<ArticlesInteractor> {
        ArticlesInteractor(repository = get())
    }
    viewModel {
        MainScreenViewModel(interactor = get(), bookmarksInteractor = get())
    }
}