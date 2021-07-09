package com.example.simpleandroidtoptech.data.dataSources.remote

import com.example.simpleandroidtoptech.data.connectionServices.ApiConnection
import com.example.simpleandroidtoptech.data.entities.CharacterEntry
import com.example.simpleandroidtoptech.data.entities.GeneralHeaderEntry

open class RemoteDataSource constructor(private val apiConnection: ApiConnection) {
    suspend fun getCharacter(): GeneralHeaderEntry<CharacterEntry> {
        return  apiConnection.getCharacter()
    }
}