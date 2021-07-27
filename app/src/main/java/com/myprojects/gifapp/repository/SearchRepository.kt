package com.myprojects.gifapp.repository

import com.myprojects.gifapp.data.model.GifItem
import java.util.*

class SearchRepository : ISearchRepository {

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

    override suspend fun getGifListViaSearch(searchString: String): List<GifItem> {
        return gifList
    }
}