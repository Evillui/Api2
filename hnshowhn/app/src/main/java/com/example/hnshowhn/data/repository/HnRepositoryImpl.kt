package com.example.hnshowhn.data.repository

import com.example.hnshowhn.data.remote.HnApi
import com.example.hnshowhn.data.remote.toUiModel
import com.example.hnshowhn.data.requestlog.LastRequestTracker
import com.example.hnshowhn.domain.repository.HnRepository
import com.example.hnshowhn.model.LastRequestInfo
import com.example.hnshowhn.model.ShowHnDetail
import com.example.hnshowhn.model.ShowHnPost
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HnRepositoryImpl @Inject constructor(
    private val api: HnApi,
    private val lastRequestTracker: LastRequestTracker
) : HnRepository {

    override val lastSuccessfulRequest: StateFlow<LastRequestInfo?> =
        lastRequestTracker.lastSuccessfulRequest

    override suspend fun getShowHnList(): List<ShowHnPost> {
        val response = api.getShowHnList(tags = "story,show_hn")

        lastRequestTracker.setSuccess(
            endpoint = "/search_by_date",
            params = "tags=story,show_hn"
        )

        return response.hits.mapNotNull { it.toUiModel() }
    }

    override suspend fun getItemDetail(id: Long): ShowHnDetail {
        val response = api.getItemDetail(id)

        // D19
        lastRequestTracker.setSuccess(
            endpoint = "/items/$id",
            params = null
        )

        return response.toUiModel()
    }
}