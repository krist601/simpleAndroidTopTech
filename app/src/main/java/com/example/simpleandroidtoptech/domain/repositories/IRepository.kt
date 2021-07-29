package com.example.simpleandroidtoptech.domain.repositories

import com.example.core.LiveDataStatus
import com.example.simpleandroidtoptech.domain.entities.CharacterMemory
import com.example.simpleandroidtoptech.domain.entities.GeneralHeaderMemory

interface IRepository {
    @Throws(Exception::class)
    suspend fun getCharacters(): Pair<LiveDataStatus, GeneralHeaderMemory<List<CharacterMemory>>?>
}