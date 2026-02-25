package com.example.hnshowhn.data.remote

import com.example.hnshowhn.data.remote.dto.HnItemDetailDto
import com.example.hnshowhn.data.remote.dto.ShowHnHitDto
import com.example.hnshowhn.model.ShowHnDetail
import com.example.hnshowhn.model.ShowHnPost

fun ShowHnHitDto.toUiModel(): ShowHnPost? {
    val parsedId = objectId?.toLongOrNull() ?: return null

    return ShowHnPost(
        id = parsedId,
        title = title?.takeIf { it.isNotBlank() } ?: "(No title)",
        author = author?.takeIf { it.isNotBlank() } ?: "unknown",
        createdAt = createdAt ?: "unknown date",
        points = points ?: 0,
        commentsCount = numComments ?: 0,
        url = url
    )
}

fun HnItemDetailDto.toUiModel(): ShowHnDetail {
    return ShowHnDetail(
        id = id ?: -1L,
        title = title?.takeIf { it.isNotBlank() } ?: "(No title)",
        author = author?.takeIf { it.isNotBlank() } ?: "unknown",
        createdAt = createdAt ?: "unknown date",
        points = points ?: 0,
        url = url,
        text = text,
        commentsCount = children?.size ?: 0
    )
}