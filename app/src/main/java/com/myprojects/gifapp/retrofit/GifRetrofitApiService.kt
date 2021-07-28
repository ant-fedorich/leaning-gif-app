package com.myprojects.gifapp.retrofit

import com.giphy.sdk.ui.GIPHY_GIF_LINK
import com.myprojects.gifapp.data.entity.GifEntityResponse
import com.myprojects.gifapp.util.AppConsts.GIPHY_API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface GifRetrofitApiService {
    @GET("v1/gifs/search?api_key=$GIPHY_API_KEY")
    suspend fun getGifListViaSearch(@Query("q") searchQuery: String, @Query("limit") limit: Int): GifEntityResponse
}