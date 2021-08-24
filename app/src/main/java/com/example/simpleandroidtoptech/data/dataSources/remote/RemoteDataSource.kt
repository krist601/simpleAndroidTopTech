package com.example.simpleandroidtoptech.data.dataSources.remote

import com.example.core.await
import com.example.simpleandroidtoptech.data.connectionServices.ApiMethods
import com.example.simpleandroidtoptech.data.entities.CharacterEntry
import com.example.simpleandroidtoptech.data.entities.GeneralHeaderEntry
import javax.inject.Inject

open class RemoteDataSource @Inject constructor(private val apiMethods: ApiMethods) {
    suspend fun getCharacter(): GeneralHeaderEntry<List<CharacterEntry>> {
        return  apiMethods.getCharacter().await()!!
    }
}