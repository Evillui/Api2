package com.example.hnshowhn.data.requestlog

import com.example.hnshowhn.model.LastRequestInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LastRequestTracker @Inject constructor() {
    private val _lastSuccessfulRequest = MutableStateFlow<LastRequestInfo?>(null)
    val lastSuccessfulRequest: StateFlow<LastRequestInfo?> = _lastSuccessfulRequest.asStateFlow()

    fun setSuccess(endpoint: String, params: String? = null) {
        _lastSuccessfulRequest.value = LastRequestInfo(endpoint, params)
    }
}