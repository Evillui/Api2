package com.example.hnshowhn.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ShowHnListResponseDto(
    @SerializedName("hits")
    val hits: List<ShowHnHitDto> = emptyList()
)

data class ShowHnHitDto(
    @SerializedName("objectID")
    val objectId: String?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("author")
    val author: String?,

    @SerializedName("created_at")
    val createdAt: String?,

    @SerializedName("url")
    val url: String?,

    @SerializedName("points")
    val points: Int?,

    @SerializedName("num_comments")
    val numComments: Int?
)