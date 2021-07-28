package com.myprojects.gifapp.repository

import com.myprojects.gifapp.data.mapper.mapToGifItem
import com.myprojects.gifapp.data.model.GifItem
import com.myprojects.gifapp.states.DataState
import com.myprojects.gifapp.retrofit.GifRetrofitApiService

class SearchRepository(
    private val service: GifRetrofitApiService
) : ISearchRepository {

    override suspend fun getGifListViaSearch(searchString: String): DataState<List<GifItem>> {
        val response = service.getGifListViaSearch(searchString, 30)
        if (response.meta.status != 200) {
            return DataState.Failure(response.meta.msg)
        }
        if (response.data.isNullOrEmpty()) {
            return DataState.EmptyResult
        }
        return DataState.Success(response.data.map { it.mapToGifItem() })
    }
}