package com.myprojects.gifapp.data.entity

import com.google.gson.annotations.SerializedName

data class GifEntityResponse (
    val data: List<GifDataResponse>,
    val meta: MetaResponse,
    val pagination: PaginationResponse
)

data class GifDataResponse (
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
    val images: ImagesSetResponse,
    val title: String
)

data class ImagesSetResponse (
    @SerializedName("fixed_height")
    val fixedHeight: ImageResponse,
    @SerializedName("fixed_height_still")
    val fixedHeightStill: ImageResponse,
    @SerializedName("fixed_height_downsampled")
    val fixedHeightDownsampled: ImageResponse,
    @SerializedName("fixed_width")
    val fixedWidth: ImageResponse,
    @SerializedName("fixed_width_still")
    val fixedWidthStill: ImageResponse,
    @SerializedName("fixed_width_downsampled")
    val fixedWidthDownsampled: ImageResponse,
    @SerializedName("fixed_height_small")
    val fixedHeightSmall: ImageResponse,
    @SerializedName("fixed_height_small_still")
    val fixedHeightSmallStill: ImageResponse,
    @SerializedName("fixed_width_small")
    val fixedWidthSmall: ImageResponse,
    @SerializedName("fixed_width_small_still")
    val fixedWidthSmallStill: ImageResponse,
    val downsized: ImageResponse,
    @SerializedName("downsized_still")
    val downsizedStill: ImageResponse,
    @SerializedName("downsized_large")
    val downsizedLarge: ImageResponse,
    val original: ImageResponse,
    @SerializedName("original_still")
    val originalStill: ImageResponse
)

data class ImageResponse (
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

data class MetaResponse (
    val status: Int,
    val msg: String
)

data class PaginationResponse (
    @SerializedName("total_count")
    val totalCount: Int,
    val count: Int,
    val offset: Int
)