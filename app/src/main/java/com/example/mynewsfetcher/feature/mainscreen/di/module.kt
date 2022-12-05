package com.example.mynewsfetcher.feature.mainscreen.di

import com.example.mynewsfetcher.feature.mainscreen.data.ArticlesRemoteSource
import com.example.mynewsfetcher.feature.mainscreen.data.ArticlesRepository
import com.example.mynewsfetcher.feature.mainscreen.data.ArticlesRepositoryImpl
import com.example.mynewsfetcher.feature.mainscreen.data.NewsApi
import com.example.mynewsfetcher.feature.mainscreen.domain.ArticlesInteractor
import com.example.mynewsfetcher.feature.mainscreen.ui.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

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