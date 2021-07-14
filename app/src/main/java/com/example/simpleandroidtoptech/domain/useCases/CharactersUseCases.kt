package com.example.simpleandroidtoptech.domain.useCases

import com.example.core.LiveDataStatus
import com.example.simpleandroidtoptech.domain.entities.CharacterMemory
import com.example.simpleandroidtoptech.domain.entities.GeneralHeaderMemory
import com.example.simpleandroidtoptech.domain.repositories.IRepository
import kotlinx.coroutines.*

class CharactersUseCases constructor(private val iRepository: IRepository) {
    private var job = Job()
    private var uiScope = CoroutineScope(Dispatchers.Main + job)

    open fun invoke(onResult: (Pair<LiveDataStatus, GeneralHeaderMemory<CharacterMemory>?>) -> Unit, onFailure: (Exception) -> Unit) {
        uiScope.launch {
            try {
                val result = withContext(Dispatchers.IO) {
                    iRepository.getCharacters()
                }
                onResult(result)
            } catch (e: Exception) {
                onFailure(e)
            }
        }
    }
}