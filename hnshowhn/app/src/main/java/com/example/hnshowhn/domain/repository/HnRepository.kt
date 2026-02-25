package com.example.hnshowhn.domain.repository

import com.example.hnshowhn.model.ShowHnDetail
import com.example.hnshowhn.model.ShowHnPost
import kotlinx.coroutines.flow.StateFlow
import com.example.hnshowhn.model.LastRequestInfo

interface HnRepository {
    suspend fun getShowHnList(): List<ShowHnPost>
    suspend fun getItemDetail(id: Long): ShowHnDetail

    val lastSuccessfulRequest: StateFlow<LastRequestInfo?>
}