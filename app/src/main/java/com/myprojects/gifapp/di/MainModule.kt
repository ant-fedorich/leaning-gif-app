package com.myprojects.gifapp.di

import com.myprojects.gifapp.repository.ISearchRepository
import com.myprojects.gifapp.repository.SearchRepository
import com.myprojects.gifapp.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    single<ISearchRepository> { SearchRepository()}

    viewModel { SearchViewModel(get()) }
}