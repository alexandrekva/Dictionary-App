package com.example.dictionary.feature_dictionary.data.remote.dto

/**
 * Data Transfer Object do campo Phonetic do Json recebido
 * necessário para o Gson transformar o Json em [WordInfoDto]
 */

data class PhoneticDto(
    val audio: String,
    val text: String
)