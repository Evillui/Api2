package com.example.hnshowhn.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hnshowhn.domain.repository.HnRepository
import com.example.hnshowhn.model.LastRequestInfo
import com.example.hnshowhn.model.ShowHnPost
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class ShowHnListViewModel @Inject constructor(
    private val repository: HnRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<ShowHnPost>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<ShowHnPost>>> = _uiState.asStateFlow()

    val lastRequest: StateFlow<LastRequestInfo?> = repository.lastSuccessfulRequest

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val items = repository.getShowHnList()
                _uiState.value = UiState.Content(items.take(20))
            } catch (e: IOException) {
                _uiState.value = UiState.Error("Нет сети или проблема с подключением")
            } catch (e: Exception) {
                _uiState.value = UiState.Error("Не удалось загрузить список Show HN")
            }
        }
    }
}