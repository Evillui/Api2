package com.example.hnshowhn.model

data class ShowHnDetail(
    val id: Long,
    val title: String,
    val author: String,
    val createdAt: String,
    val points: Int,
    val url: String?,
    val text: String?,
    val commentsCount: Int
)