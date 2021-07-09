package com.example.simpleandroidtoptech.domain.repositories

import com.example.core.ResponsesCode
import com.example.simpleandroidtoptech.domain.entities.CharacterMemory
import com.example.simpleandroidtoptech.domain.entities.GeneralHeaderMemory

interface IRepository {
    @Throws(Exception::class)
    suspend fun getCharacters(): Pair<com.example.core.ResponsesCode, GeneralHeaderMemory<List<CharacterMemory>>?>
}