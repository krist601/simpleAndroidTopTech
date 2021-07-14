package com.example.simpleandroidtoptech.domain.repositories

import com.example.core.LiveDataStatus
import com.example.simpleandroidtoptech.data.dataSources.local.LocalDataSource
import com.example.simpleandroidtoptech.data.dataSources.remote.RemoteDataSource
import com.example.simpleandroidtoptech.domain.entities.CharacterMemory
import com.example.simpleandroidtoptech.domain.entities.GeneralHeaderMemory

class Repository constructor(private val localDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource): IRepository {
    override suspend fun getCharacters(): Pair<LiveDataStatus, GeneralHeaderMemory<CharacterMemory>?> {
        val filterString = "characterList"
        runCatching {
            remoteDataSource.getCharacter()
        }.onSuccess { response ->
            localDataSource.setCharacters(filterString, response)
            return Pair(com.example.core.LiveDataStatus.SUCCESS, response.toEntityMemory())
        }.onFailure {
            return Pair(com.example.core.LiveDataStatus.SUCCESS, localDataSource.getCharacters(filterString)?.toEntityMemory())
        }
        return Pair(com.example.core.LiveDataStatus.ERROR, null)
    }
}