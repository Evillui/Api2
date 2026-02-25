package com.example.hnshowhn.ui.screen

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hnshowhn.ui.viewmodel.ShowHnDetailViewModel
import com.example.hnshowhn.ui.viewmodel.UiState
import com.example.hnshowhn.ui.widget.LastRequestFooter
import com.example.hnshowhn.ui.util.cleanHtmlForUi

@Composable
fun ShowHnDetailScreen(
    itemId: Long,
    onBack: () -> Unit,
    viewModel: ShowHnDetailViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    val lastRequest by viewModel.lastRequest.collectAsState()

    LaunchedEffect(itemId) {
        viewModel.load(itemId)
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(12.dp)
    ) {
        Text(
            text = "Detail (id=$itemId)",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        when (val s = state) {
            UiState.Loading -> {
                Text("Loading...")
            }

            is UiState.Error -> {
                Text(s.message)
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { viewModel.load(itemId) }) {
                    Text("Retry")
                }

                Spacer(modifier = Modifier.height(12.dp))
                Button(onClick = onBack) {
                    Text("Back")
                }
            }

            is UiState.Content -> {
                val d = s.data

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer
                    )
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            text = d.title,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Author: ${d.author}")
                        Text("Points: ${d.points}")
                        Text("Comments: ${d.commentsCount}")
                        Text("Created: ${d.createdAt}")
                        Text("URL: ${d.url ?: "—"}")

                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Text:")
                        Text((d.text ?: "No text").cleanHtmlForUi())
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))
                Button(onClick = onBack) {
                    Text("Back")
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        LastRequestFooter(request = lastRequest)
    }
}