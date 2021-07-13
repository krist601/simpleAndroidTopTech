package com.example.simpleandroidtoptech.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleandroidtoptech.domain.entities.CharacterMemory
import com.example.simpleandroidtoptech.domain.entities.GeneralHeaderMemory
import com.example.simpleandroidtoptech.domain.useCases.CharactersUseCases
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Error

class CharactersViewModel constructor(private val charactersUseCases: CharactersUseCases): ViewModel(){
    val dataLiveData = MutableLiveData<GeneralHeaderMemory<CharacterMemory>?>()

    fun getCharacters(){
        fun handleSuccess(response: Any) {

        }
        fun handleFailure(failure: Error) {

        }
        CoroutineScope(Dispatchers.IO).launch {
            charactersUseCases.invoke()
        }
    }
}