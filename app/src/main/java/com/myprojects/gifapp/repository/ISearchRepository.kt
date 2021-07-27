package com.myprojects.gifapp.repository

import com.myprojects.gifapp.data.model.GifItem

interface ISearchRepository {
    suspend fun getGifListViaSearch(searchString: String): List<GifItem>
}