package com.example.simpleandroidtoptech.domain.repositories

import com.example.core.ResponseCodes
import com.example.simpleandroidtoptech.data.dataSources.local.LocalDataSource
import com.example.simpleandroidtoptech.data.dataSources.remote.RemoteDataSource
import com.example.simpleandroidtoptech.domain.entities.CharacterMemory
import com.example.simpleandroidtoptech.domain.entities.GeneralHeaderMemory

class Repository constructor(private val localDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource): IRepository {
    override suspend fun getCharacters(): Pair<ResponseCodes, GeneralHeaderMemory<CharacterMemory>?> {
        val filterString = "characterList"
        runCatching {
            remoteDataSource.getCharacter()
        }.onSuccess { response ->
            localDataSource.setCharacters(filterString, response)
            return Pair(com.example.core.ResponseCodes.SUCCESS, response.toEntityMemory())
        }.onFailure {
            return Pair(com.example.core.ResponseCodes.SUCCESS, localDataSource.getCharacters(filterString)?.toEntityMemory())
        }
        return Pair(com.example.core.ResponseCodes.ERROR, null)
    }
}