package com.example.dictionary.feature_dictionary.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WordInfoList(
    wordInfoState: WordInfoState
) {
    if (wordInfoState.isLoading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(wordInfoState.wordInfoItems.size) { i ->
                val wordInfo = wordInfoState.wordInfoItems[i]

                if (i > 0) {
                    Spacer(modifier = Modifier.height(8.dp))
                }
                WordInfoItem(wordInfo = wordInfo)
                if (i < wordInfoState.wordInfoItems.size - 1) {
                    Divider()
                }
            }
        }
    }
}