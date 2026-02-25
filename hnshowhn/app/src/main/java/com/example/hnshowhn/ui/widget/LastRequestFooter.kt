package com.example.hnshowhn.ui.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hnshowhn.model.LastRequestInfo

@Composable
fun LastRequestFooter(
    request: LastRequestInfo?
) {
    Text(
        text = "Last request: ${request?.asDisplayText() ?: "—"}",
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        style = MaterialTheme.typography.bodySmall
    )
}