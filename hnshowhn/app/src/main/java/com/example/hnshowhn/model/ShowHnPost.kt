package com.example.hnshowhn.model

data class ShowHnPost(
    val id: Long,
    val title: String,
    val author: String,
    val createdAt: String,
    val points: Int,
    val commentsCount: Int,
    val url: String?
)