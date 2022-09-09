package com.example.mynewsfetcher.feature.newsinfo.di

import com.example.mynewsfetcher.feature.newsinfo.ui.InfoScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val infoScreenModule = module {
    viewModel { InfoScreenViewModel() }
}