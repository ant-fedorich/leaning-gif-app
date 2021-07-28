package com.myprojects.gifapp.di

import com.myprojects.gifapp.repository.ISearchRepository
import com.myprojects.gifapp.repository.SearchRepository
import com.myprojects.gifapp.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import kotlin.math.sin

val mainModule = module {
    single { InjectionHelper.provideGifRetrofitClient() }
    single { InjectionHelper.provideGifRetrofitApiService(get()) }

    single<ISearchRepository> { SearchRepository(get())}

    viewModel { SearchViewModel(get()) }


}