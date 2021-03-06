package com.example.dictionary.feature_dictionary.data.remote.dto

import com.example.dictionary.feature_dictionary.domain.models.Meaning

/**
 * Data Transfer Object do [Meaning]
 */

data class MeaningDto(
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String
) {
    fun toMeaning(): Meaning {
        return Meaning(
            definition = definitions.map { it.toDefinition() },
            partOfSpeech = partOfSpeech
        )
    }
}