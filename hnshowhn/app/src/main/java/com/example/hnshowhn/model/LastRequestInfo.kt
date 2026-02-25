package com.example.hnshowhn.model

data class LastRequestInfo(
    val endpoint: String,
    val params: String? = null
) {
    fun asDisplayText(): String {
        return if (params.isNullOrBlank()) endpoint else "$endpoint?$params"
    }
}