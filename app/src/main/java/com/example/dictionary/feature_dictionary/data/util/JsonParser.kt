package com.example.dictionary.feature_dictionary.data.util

import java.lang.reflect.Type

/**
 * Interface de métodos para transformar um objeto to tipo Json em um
 * objeto do nosso model
 */

interface JsonParser {

    fun <T> fromJson(json: String, type: Type): T?

    fun <T> toJson(obj: T, type: Type): String?
}