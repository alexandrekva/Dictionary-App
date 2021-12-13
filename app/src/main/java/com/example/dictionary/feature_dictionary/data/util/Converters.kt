package com.example.dictionary.feature_dictionary.data.util

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.dictionary.feature_dictionary.domain.models.Meaning
import com.google.gson.reflect.TypeToken

/**
 * Classe para conversão de [Meaning] <-> Json
 * necessária para o Room Databse
 */

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromMeaningsJson(json: String): List<Meaning> {
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object : TypeToken<ArrayList<Meaning>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun fromJsonMeanings(meanings: List<Meaning>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<Meaning>>() {}.type
        ) ?: "[]"
    }
}