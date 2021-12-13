package com.example.dictionary.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionary.feature_dictionary.domain.models.Meaning
import com.example.dictionary.feature_dictionary.domain.models.WordInfo

/**
 * Entidade da classe [WordInfo]
 * necessária para o Room Database
 *
 * OBS: O campo "phonetics" não é utilizado no projeto e por isso não temos esse
 * campo no [WordInfoEntity]/[WordInfo]
 */

@Entity
data class WordInfoEntity(
    val word: String,
    val phonetic: String?,
    val origin: String?,
    val meanings: List<Meaning>,
    @PrimaryKey val id: Int? = null
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            word = word,
            phonetic = phonetic,
            origin = origin,
            meanings = meanings
        )
    }
}