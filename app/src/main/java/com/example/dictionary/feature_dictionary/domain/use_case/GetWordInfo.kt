package com.example.dictionary.feature_dictionary.domain.use_case

import com.example.dictionary.core.util.Resource
import com.example.dictionary.feature_dictionary.domain.models.WordInfo
import com.example.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Caso de uso da feature get word info
 */

class GetWordInfo(
    private val repository: WordInfoRepository
) {
    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        if (word.isBlank()) {
            return flow { }
        }

        return repository.getWordInfo(word)
    }
}