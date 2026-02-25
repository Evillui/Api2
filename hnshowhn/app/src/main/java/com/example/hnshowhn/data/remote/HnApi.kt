package com.example.hnshowhn.data.remote

import com.example.hnshowhn.data.remote.dto.HnItemDetailDto
import com.example.hnshowhn.data.remote.dto.ShowHnListResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HnApi {

    @GET("search_by_date")
    suspend fun getShowHnList(
        @Query("tags") tags: String = "story,show_hn"
    ): ShowHnListResponseDto

    @GET("search_by_date")
    suspend fun searchStories(
        @Query("query") query: String,
        @Query("tags") tags: String = "story"
    ): ShowHnListResponseDto

    @GET("items/{id}")
    suspend fun getItemDetail(
        @Path("id") id: Long
    ): HnItemDetailDto
}