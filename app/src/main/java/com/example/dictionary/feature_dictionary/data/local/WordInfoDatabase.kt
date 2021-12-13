package com.example.dictionary.feature_dictionary.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.dictionary.feature_dictionary.data.local.entity.WordInfoEntity
import com.example.dictionary.feature_dictionary.data.util.Converters

/**
 * Configuração do banco de dados do Room Database
 */

@Database(
    entities = [WordInfoEntity::class],
    version = 3
)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase : RoomDatabase() {
    abstract val dao: WordInfoDao
}