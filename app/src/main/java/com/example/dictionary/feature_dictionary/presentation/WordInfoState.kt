package com.example.dictionary.feature_dictionary.presentation

import com.example.dictionary.feature_dictionary.domain.models.WordInfo

/**
 * Classe responsável por guardar o estado atual de um word info
 */

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)