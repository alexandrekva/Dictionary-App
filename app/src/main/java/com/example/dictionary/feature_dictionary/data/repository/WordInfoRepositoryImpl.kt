package com.example.dictionary.feature_dictionary.data.repository

import com.example.dictionary.core.util.Resource
import com.example.dictionary.feature_dictionary.data.local.WordInfoDao
import com.example.dictionary.feature_dictionary.data.remote.DictionaryApi
import com.example.dictionary.feature_dictionary.domain.models.WordInfo
import com.example.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao
) : WordInfoRepository {

    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfo = dao.getWordInfos(word).map { it.toWordInfo() }
        emit(Resource.Loading(wordInfo))

        try {
            val remoteWordInfos = api.getWordInfo(word = word)
            dao.deleteWordInfos(remoteWordInfos.map { it.word })
            dao.insertWordInfos(remoteWordInfos.map { it.toWordInfoEntity() })
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Algo deu errado!\n${e.message}",
                    data = wordInfo
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Algo deu errado!\n${e.message}",
                    data = wordInfo
                )
            )
        }

        val newWordInfo = dao.getWordInfos(word = word).map { it.toWordInfo() }
        emit(Resource.Success(newWordInfo))
    }
}