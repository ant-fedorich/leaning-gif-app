package com.myprojects.gifapp.data.mapper

import com.myprojects.gifapp.data.entity.GifDataResponse
import com.myprojects.gifapp.data.model.GifItem

fun GifDataResponse.mapToGifItem(): GifItem {
    return GifItem(
        id = this.id,
        fullImageUrl = this.images.original.url,
        previewImageUrl = this.images.fixedHeightSmallStill.url
    )
}