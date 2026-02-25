package com.example.hnshowhn.data.remote.dto

import com.google.gson.annotations.SerializedName

data class HnItemDetailDto(
    @SerializedName("id")
    val id: Long?,

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

    @SerializedName("text")
    val text: String?,

    @SerializedName("children")
    val children: List<HnCommentDto>? = emptyList()
)

data class HnCommentDto(
    @SerializedName("id")
    val id: Long?,

    @SerializedName("author")
    val author: String?,

    @SerializedName("text")
    val text: String?
)