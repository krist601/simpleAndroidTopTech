package com.example.simpleandroidtoptech.data.dataSources.remote

import com.example.simpleandroidtoptech.data.connectionServices.ApiMethods
import com.example.simpleandroidtoptech.data.entities.CharacterEntry
import com.example.simpleandroidtoptech.data.entities.GeneralHeaderEntry

open class RemoteDataSource constructor(private val apiMethods: ApiMethods) {
    suspend fun getCharacter(): GeneralHeaderEntry<CharacterEntry> {
        return  apiMethods.getCharacter()
    }
}