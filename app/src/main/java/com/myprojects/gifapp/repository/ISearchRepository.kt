package com.myprojects.gifapp.repository

import com.myprojects.gifapp.data.model.GifItem
import com.myprojects.gifapp.states.DataState

interface ISearchRepository {
    suspend fun getGifListViaSearch(searchString: String): DataState<List<GifItem>>
}