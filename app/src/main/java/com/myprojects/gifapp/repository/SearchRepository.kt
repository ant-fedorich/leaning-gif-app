package com.myprojects.gifapp.repository

import com.myprojects.gifapp.data.entity.GifData
import com.myprojects.gifapp.data.entity.GifEntityResponse
import com.myprojects.gifapp.data.model.GifItem
import com.myprojects.gifapp.retrofit.GifRetrofitApiService
import java.util.*

class SearchRepository(
    private val service: GifRetrofitApiService
) : ISearchRepository {

    private val gifList = listOf(
        GifItem(
            id = System.currentTimeMillis().toString(),
            importDate = System.currentTimeMillis().toString(),
            imageUrl = android.R.drawable.bottom_bar.toString()
        ),
        GifItem(
            id = System.currentTimeMillis().toString(),
            importDate = System.currentTimeMillis().toString(),
            imageUrl = android.R.drawable.alert_light_frame.toString()
        ),
        GifItem(
            id = System.currentTimeMillis().toString(),
            importDate = System.currentTimeMillis().toString(),
            imageUrl = android.R.drawable.dialog_frame.toString()
        ),
        GifItem(
            id = System.currentTimeMillis().toString(),
            importDate = System.currentTimeMillis().toString(),
            imageUrl = android.R.drawable.bottom_bar.toString()
        ),
        GifItem(
            id = System.currentTimeMillis().toString(),
            importDate = System.currentTimeMillis().toString(),
            imageUrl = android.R.drawable.alert_light_frame.toString()
        ),
        GifItem(
            id = System.currentTimeMillis().toString(),
            importDate = System.currentTimeMillis().toString(),
            imageUrl = android.R.drawable.dialog_frame.toString()
        ),
        GifItem(
            id = System.currentTimeMillis().toString(),
            importDate = System.currentTimeMillis().toString(),
            imageUrl = android.R.drawable.bottom_bar.toString()
        ),
        GifItem(
            id = System.currentTimeMillis().toString(),
            importDate = System.currentTimeMillis().toString(),
            imageUrl = android.R.drawable.alert_light_frame.toString()
        ),
        GifItem(
            id = System.currentTimeMillis().toString(),
            importDate = System.currentTimeMillis().toString(),
            imageUrl = android.R.drawable.dialog_frame.toString()
        )
    )

    override suspend fun getGifListViaSearch(searchString: String): List<GifData> {
        val response = service.getGifListViaSearch(searchString, 30)
        return response.data
    }
}