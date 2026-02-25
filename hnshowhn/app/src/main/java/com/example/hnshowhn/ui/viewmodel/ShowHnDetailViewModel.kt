package com.example.hnshowhn.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hnshowhn.domain.repository.HnRepository
import com.example.hnshowhn.model.LastRequestInfo
import com.example.hnshowhn.model.ShowHnDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class ShowHnDetailViewModel @Inject constructor(
    private val repository: HnRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<ShowHnDetail>>(UiState.Loading)
    val uiState: StateFlow<UiState<ShowHnDetail>> = _uiState.asStateFlow()

    val lastRequest: StateFlow<LastRequestInfo?> = repository.lastSuccessfulRequest

    fun load(id: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val detail = repository.getItemDetail(id)
                _uiState.value = UiState.Content(detail)
            } catch (e: IOException) {
                _uiState.value = UiState.Error("Нет сети или проблема с подключением")
            } catch (e: Exception) {
                _uiState.value = UiState.Error("Не удалось загрузить детали элемента id=$id")
            }
        }
    }
}