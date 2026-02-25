package com.example.hnshowhn.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hnshowhn.ui.viewmodel.ShowHnListViewModel
import com.example.hnshowhn.ui.viewmodel.UiState
import com.example.hnshowhn.ui.widget.LastRequestFooter
import com.example.hnshowhn.ui.widget.ShowHnItemCard

private const val VARIANT_CODE = "HNALG-SHOWHN-MOD_D19_LAST_REQUEST_LOG"

@Composable
fun ShowHnListScreen(
    onOpenDetail: (Long) -> Unit,
    viewModel: ShowHnListViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    val lastRequest by viewModel.lastRequest.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Text(
            text = "Show HN List",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "VariantCode: $VARIANT_CODE",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(top = 4.dp, bottom = 8.dp)
        )

        when (val s = state) {
            UiState.Loading -> {
                Box(
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is UiState.Error -> {
                Column(
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = s.message)
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = { viewModel.load() }) {
                        Text("Retry")
                    }
                }
            }

            is UiState.Content -> {
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(s.data, key = { it.id }) { item ->
                        ShowHnItemCard(
                            item = item,
                            onClick = { onOpenDetail(item.id) }
                        )
                    }
                }
            }
        }

        LastRequestFooter(request = lastRequest)
    }
}