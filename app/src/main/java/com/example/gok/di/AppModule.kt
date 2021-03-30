package com.example.gok.di

import com.example.gok.data.repository.GokApiDataSource
import com.example.gok.ui.RootViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val androidModule = module {
    single { this }

    viewModel {
        RootViewModel( GokApiDataSource() )
    }
}