package com.example.simpleandroidtoptech.domain.repositories

import com.example.core.ResponseCodes
import com.example.simpleandroidtoptech.domain.entities.CharacterMemory
import com.example.simpleandroidtoptech.domain.entities.GeneralHeaderMemory

interface IRepository {
    @Throws(Exception::class)
    suspend fun getCharacters(): Pair<ResponseCodes, GeneralHeaderMemory<CharacterMemory>?>
}