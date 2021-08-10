package com.example.simpleandroidtoptech.data.connectionServices

import com.example.simpleandroidtoptech.data.connectionServices.ApiConstants.PATH_CHARACTERS
import com.example.simpleandroidtoptech.data.entities.CharacterEntry
import com.example.simpleandroidtoptech.data.entities.GeneralHeaderEntry
import retrofit2.http.GET

interface ApiMethods {
    @GET(PATH_CHARACTERS)
    fun getCharacter(): GeneralHeaderEntry<CharacterEntry>
}