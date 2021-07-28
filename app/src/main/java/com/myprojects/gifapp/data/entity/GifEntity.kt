package com.myprojects.gifapp.data.entity

import com.google.gson.annotations.SerializedName

//data class GifEntity (
//    @SerializedName("")
//    val id: String,
//    val url: String
//)




data class GifEntityResponse (
    val data: List<GifData>,
    val meta: Meta,
    val pagination: Pagination
)

data class GifData (
    val type: String,
    val id: String,
    val slug: String,
    val url: String,
    @SerializedName("bitly_gif_url")
    val bitlyGIFURL: String,
    @SerializedName("bitly_url")
    val bitlyURL: String,
    @SerializedName("embed_url")
    val embedURL: String,
    val username: String,
    val source: String,
    val rating: String,
    val caption: String,
    @SerializedName("content_url")
    val contentURL: String,
    @SerializedName("source_tld")
    val sourceTLD: String,
    @SerializedName("source_post_url")
    val sourcePostURL: String,
    @SerializedName("import_datetime")
    val importDatetime: String,
    @SerializedName("trending_datetime")
    val trendingDatetime: String,
    val images: ImagesSet,
    val title: String
)

data class ImagesSet (
    @SerializedName("fixed_height")
    val fixedHeight: ImageItem,
    @SerializedName("fixed_height_still")
    val fixedHeightStill: ImageItem,
    @SerializedName("fixed_height_downsampled")
    val fixedHeightDownsampled: ImageItem,
    @SerializedName("fixed_width")
    val fixedWidth: ImageItem,
    @SerializedName("fixed_width_still")
    val fixedWidthStill: ImageItem,
    @SerializedName("fixed_width_downsampled")
    val fixedWidthDownsampled: ImageItem,
    @SerializedName("fixed_height_small")
    val fixedHeightSmall: ImageItem,
    @SerializedName("fixed_height_small_still")
    val fixedHeightSmallStill: ImageItem,
    @SerializedName("fixed_width_small")
    val fixedWidthSmall: ImageItem,
    @SerializedName("fixed_width_small_still")
    val fixedWidthSmallStill: ImageItem,
    val downsized: ImageItem,
    @SerializedName("downsized_still")
    val downsizedStill: ImageItem,
    @SerializedName("downsized_large")
    val downsizedLarge: ImageItem,
    val original: ImageItem,
    @SerializedName("original_still")
    val originalStill: ImageItem
)

data class ImageItem (
    val url: String,
    val width: String,
    val height: String,
    val size: String? = null,
    val mp4: String? = null,
    @SerializedName("mp4_size")
    val mp4Size: String? = null,
    val webp: String? = null,
    @SerializedName("webp_size")
    val webpSize: String? = null,
    val frames: String? = null
)

data class Meta (
    val status: Long,
    val msg: String
)

data class Pagination (
    @SerializedName("total_count")
    val totalCount: Long,
    val count: Long,
    val offset: Long
)