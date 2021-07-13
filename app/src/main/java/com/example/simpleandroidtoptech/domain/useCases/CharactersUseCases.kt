package com.example.simpleandroidtoptech.domain.useCases

import com.example.core.ResponseCodes
import com.example.simpleandroidtoptech.domain.entities.CharacterMemory
import com.example.simpleandroidtoptech.domain.entities.GeneralHeaderMemory
import com.example.simpleandroidtoptech.domain.repositories.IRepository

class CharactersUseCases constructor(private val iRepository: IRepository) {
    suspend operator fun invoke(): Pair<ResponseCodes, GeneralHeaderMemory<CharacterMemory>?> = iRepository.getCharacters()
}